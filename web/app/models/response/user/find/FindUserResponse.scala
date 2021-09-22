package models.response.user.find

import dev.tchiba.ddd.domain.models.entities.user.User
import play.api.libs.json.{JsValue, Json, OFormat}

import java.util.UUID

case class FindUserResponse(
    id: UUID,
    firstName: String,
    lastName: String
) {
  def toJson: JsValue = Json.toJson(this)
}

object FindUserResponse {
  implicit val jsonFormat: OFormat[FindUserResponse] = Json.format[FindUserResponse]

  def from(user: User): FindUserResponse = {
    FindUserResponse(
      id = user.id.value,
      firstName = user.name.firstName,
      lastName = user.name.lastName
    )
  }
}
