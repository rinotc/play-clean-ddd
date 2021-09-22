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

  override def add(user: User): Future[UserId] = {
    val action = userTable += UserRow(user.id.value, user.name.fullName)
    db.run(action).map { _ => user.id }
  }
}
