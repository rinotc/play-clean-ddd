package dev.tchiba.ddd
package web.controllers.user

import dev.tchiba.ddd.domain.models.entities.user.{User, UserId, UserRepository}
import dev.tchiba.ddd.domain.models.valueObjects.person.FullName
import dev.tchiba.ddd.web.models.request.user.add.AddUserRequest
import play.api.mvc.{AbstractController, Action, ControllerComponents}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class UserController @Inject() (cc: ControllerComponents)(implicit ec: ExecutionContext)
    extends AbstractController(cc) {

  implicit class FutureOps[T](value: T) {
    def future: Future[T] = Future.successful(value)
  }

  class UserRepo extends UserRepository {
    override def add(user: User): Future[Either[Conflict, UserId]] = {
      if (user.name == FullName("太郎", "田中")) Left(Conflict(UserId.generate)).future else Right(UserId.generate).future
    }

    override def contains(fullName: FullName): Future[Boolean] = {
      (fullName == FullName("田中", "太郎")).future
    }
  }

  def add: Action[AddUserRequest] = Action.async(AddUserRequest.validateJson(cc.parsers, new UserRepo)) {
    implicit request =>
      Ok(request.body.fullName.fullName).future
  }
}
