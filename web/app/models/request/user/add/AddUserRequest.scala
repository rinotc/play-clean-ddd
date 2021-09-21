package models.request.user.add

import dev.tchiba.ddd.domain.models.entities.user.UserRepository
import dev.tchiba.ddd.domain.models.valueObjects.person.FullName
import play.api.libs.json.{Json, OFormat}
import play.api.mvc.Results.{BadRequest, Conflict}
import play.api.mvc.{BodyParser, PlayBodyParsers}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

case class AddUserRequest(
    firstName: String,
    lastName: String
) {
  require(firstName != "田中")
  val fullName: FullName = FullName(firstName, lastName)
}

object AddUserRequest {
  implicit val jsonFormat: OFormat[AddUserRequest] = Json.format[AddUserRequest]

  def validateJson(
      parsers: PlayBodyParsers,
      userRepository: UserRepository
  )(implicit ec: ExecutionContext): BodyParser[AddUserRequest] = {
    parsers.json.validateM { jsValue =>
      Try(jsValue.validate[AddUserRequest]) match {
        case Failure(e) => Future.successful(Left(BadRequest("validate failed")))
        case Success(value) =>
          value.asEither match {
            case Left(_) => Future.successful(Left(BadRequest("json format error")))
            case Right(request) =>
              val fullName = FullName(request.firstName, request.lastName)
              userRepository.contains(fullName).map { flag =>
                if (flag) Left(Conflict("user already exists"))
                else Right(request)
              }
          }
      }
    }
  }
}
