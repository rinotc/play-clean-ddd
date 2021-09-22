package models.request

import play.api.libs.json.{Json, Reads}
import play.api.mvc.Results.BadRequest
import play.api.mvc.{BodyParser, PlayBodyParsers, Result}

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}

trait JsonValidator {
  def jsonValidate[A: Reads](
      fail: Throwable => Result
  )(implicit parsers: PlayBodyParsers, ec: ExecutionContext): BodyParser[A] = {
    parsers.json.validate[A] { jsValue =>
      Try(jsValue.validate[A]) match {
        case Failure(e) => Left(fail(e))
        case Success(value) =>
          value.asEither.left.map { _ =>
            BadRequest(Json.toJson("parse error"))
          }
      }
    }
  }
}
