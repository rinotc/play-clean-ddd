package dev.tchiba.ddd.infrastructure.rdb.user

import slick.jdbc.JdbcProfile

import java.util.UUID

case class UserRow(
    id: UUID,
    name: String
)

trait UserTableDefinition {
  protected val profile: JdbcProfile

  import profile.api._

  class UserTable(tag: Tag) extends Table[UserRow](tag, "user") {
    val id   = column[UUID]("user_id")
    val name = column[String]("user_name")

    override def * = (id, name).<>(UserRow.tupled, UserRow.unapply)
  }

  protected val userTable = TableQuery[UserTable]
}
