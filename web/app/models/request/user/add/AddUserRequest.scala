package models.request.user.add

import dev.tchiba.ddd.domain.models.valueObjects.person.FullName
import models.request.JsonValidator
import play.api.libs.json.{Json, OFormat}
import play.api.mvc.Results.BadRequest
import play.api.mvc.{BodyParser, PlayBodyParsers}

import scala.concurrent.ExecutionContext

case class AddUserRequest(
    firstName: String,
    lastName: String
) {
  val fullName: FullName = FullName(firstName, lastName)
}

object AddUserRequest extends JsonValidator {
  implicit val jsonFormat: OFormat[AddUserRequest] = Json.format[AddUserRequest]

  def validateJson(implicit parsers: PlayBodyParsers, ec: ExecutionContext): BodyParser[AddUserRequest] = jsonValidate {
    case e: IllegalArgumentException => BadRequest(e.getMessage)
  }
}
