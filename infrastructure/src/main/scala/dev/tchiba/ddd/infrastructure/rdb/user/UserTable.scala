package dev.tchiba.ddd.infrastructure.rdb.user

import dev.tchiba.ddd.domain.models.entities.user.{User, UserId}
import dev.tchiba.ddd.domain.models.valueObjects.person.FullName
import slick.jdbc.JdbcProfile

import java.util.UUID

case class UserRow(
    id: UUID,
    firstName: String,
    lastName: String
) {
  def toUser: User = new User(UserId(id), FullName(firstName, lastName))
}

object UserRow {
  def from(user: User): UserRow = UserRow(user.id.value, user.name.firstName, user.name.lastName)
}

trait UserTableDefinition {
  protected val profile: JdbcProfile

  import profile.api._

  class UserTable(tag: Tag) extends Table[UserRow](tag, "user") {
    val id        = column[UUID]("user_id")
    val firstName = column[String]("first_name")
    val lastName  = column[String]("last_name")

    override def * = (id, firstName, lastName).<>((UserRow.apply _).tupled, UserRow.unapply)
  }

  protected val userTable = TableQuery[UserTable]
}
