package controllers

import play.api.mvc.Result
import play.api.mvc.Results.BadRequest

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object QueryValidator {
  def async[R](f: => R)(g: R => Future[Result]): Future[Result] = {
    Try(f) match {
      case Failure(exception) => Future.successful(BadRequest(exception.getMessage))
      case Success(value)     => g(value)
    }
  }

  def sync[R](f: => R)(g: R => Result): Result = {
    Try(f) match {
      case Failure(exception) => BadRequest(exception.getMessage)
      case Success(value)     => g(value)
    }
  }
}
