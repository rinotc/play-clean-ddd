package controllers.user

import dev.tchiba.ddd.domain.usecases.users.add.{AddUserInput, AddUserOutput, AddUserUseCase}
import models.request.user.add.AddUserRequest
import models.response.user.add.AddUserResponse
import play.api.mvc.{AbstractController, Action, ControllerComponents, PlayBodyParsers}

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class UserController @Inject() (cc: ControllerComponents, addUserUseCase: AddUserUseCase)(implicit ec: ExecutionContext)
    extends AbstractController(cc) {

  implicit private val parsers: PlayBodyParsers = cc.parsers

  def add: Action[AddUserRequest] = Action.async(AddUserRequest.validateJson) { implicit request =>
    val input = AddUserInput(request.body.fullName)
    addUserUseCase.handle(input).map { case AddUserOutput.Success(userId) =>
      Ok(AddUserResponse.from(userId).toJson)
    }
  }
}
