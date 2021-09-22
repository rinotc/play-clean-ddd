package models.response.user.add

import dev.tchiba.ddd.domain.models.entities.user.UserId
import play.api.libs.json.{JsValue, Json, OFormat}

case class AddUserResponse(newUserId: String) {
  def toJson: JsValue = Json.toJson(this)
}

object AddUserResponse {
  implicit val jsonFormat: OFormat[AddUserResponse] = Json.format[AddUserResponse]

  def from(newUserId: UserId): AddUserResponse = {
    AddUserResponse(newUserId.value.toString)
  }
}
