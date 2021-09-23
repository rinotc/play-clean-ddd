package models.response.user.list

import dev.tchiba.ddd.domain.models.entities.user.User
import play.api.libs.json.{JsValue, Json, OFormat}

import java.util.UUID

case class ListUsersResponse(
    id: UUID,
    firstName: String,
    lastName: String
)

object ListUsersResponse {
  implicit val jsonFormat: OFormat[ListUsersResponse] = Json.format[ListUsersResponse]

  implicit class ListUsersResponseOps(values: Seq[ListUsersResponse]) {
    def toJson: JsValue = Json.toJson(values)
  }

  def fromSeq(users: Seq[User]): Seq[ListUsersResponse] = {
    users.map { user =>
      ListUsersResponse(
        id = user.id.value,
        firstName = user.name.firstName,
        lastName = user.name.lastName
      )
    }
  }
}
