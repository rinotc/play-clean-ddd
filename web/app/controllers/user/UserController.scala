package controllers.user

import controllers.QueryValidator
import dev.tchiba.ddd.domain.models.entities.user.UserId
import dev.tchiba.ddd.domain.models.valueObjects.paging.Pagination
import dev.tchiba.ddd.domain.usecases.users.add.{AddUserInput, AddUserOutput, AddUserUseCase}
import dev.tchiba.ddd.domain.usecases.users.find.{FindUserInput, FindUserOutput, FindUserUseCase}
import dev.tchiba.ddd.domain.usecases.users.list.{ListUsersInput, ListUsersOutput, ListUsersUseCase}
import models.request.user.add.AddUserRequest
import models.response.user.add.AddUserResponse
import models.response.user.find.FindUserResponse
import models.response.user.list.ListUsersResponse
import play.api.mvc._

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.ExecutionContext

class UserController @Inject() (
    cc: ControllerComponents,
    addUserUseCase: AddUserUseCase,
    findUserUseCase: FindUserUseCase,
    listUsersUseCase: ListUsersUseCase
)(implicit ec: ExecutionContext)
    extends AbstractController(cc) {

  implicit private val parsers: PlayBodyParsers = cc.parsers

  def add: Action[AddUserRequest] = Action.async(AddUserRequest.validateJson) { implicit request =>
    val input = AddUserInput(request.body.fullName)
    addUserUseCase.handle(input).map { case AddUserOutput.Success(userId) =>
      Ok(AddUserResponse.from(userId).toJson)
    }
  }

  def list(page: Int, perPage: Int): Action[AnyContent] = Action.async { implicit request =>
    QueryValidator.async {
      val pagination = Pagination(page, perPage)
      ListUsersInput(pagination)
    } { input =>
      listUsersUseCase.handle(input).map { case ListUsersOutput.Success(users) =>
        Ok(ListUsersResponse.fromSeq(users).toJson)
      }
    }
  }

  def find(id: UUID): Action[AnyContent] = Action.async { implicit request =>
    QueryValidator.async {
      FindUserInput(UserId(id))
    } { input =>
      findUserUseCase.handle(input).map {
        case FindUserOutput.Success(user) => Ok(FindUserResponse.from(user).toJson)
        case FindUserOutput.NotFound(id)  => NotFound(s"not found user: ${id.value}")
      }
    }
  }
}
