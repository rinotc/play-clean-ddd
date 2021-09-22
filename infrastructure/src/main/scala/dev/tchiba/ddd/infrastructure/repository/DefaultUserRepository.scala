package dev.tchiba.ddd.infrastructure.repository

import dev.tchiba.ddd.domain.models.entities.user.{User, UserId, UserRepository}
import dev.tchiba.ddd.infrastructure.rdb.PostgresDatabaseConfig
import dev.tchiba.ddd.infrastructure.rdb.user.{UserRow, UserTableDefinition}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class DefaultUserRepository @Inject() ()(implicit ec: ExecutionContext)
    extends UserRepository
    with PostgresDatabaseConfig
    with UserTableDefinition {

  import profile.api._

  override def find(id: UserId): Future[Option[User]] = {
    val query = userTable.filter(_.id === id.value).result.headOption
    db.run(query).map(_.map(_.toUser))
  }

  override def add(user: User): Future[UserId] = {
    val action = userTable += UserRow.from(user)
    db.run(action).map { _ => user.id }
  }
}
