package dev.tchiba.ddd.application.interactors.users.find

import dev.tchiba.ddd.domain.models.entities.user.UserRepository
import dev.tchiba.ddd.domain.usecases.users.find.{FindUserInput, FindUserOutput, FindUserUseCase}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class FindUserInteractor @Inject() (userRepository: UserRepository)(implicit ec: ExecutionContext)
    extends FindUserUseCase {
  override def handle(input: FindUserInput): Future[FindUserOutput] = {
    userRepository.find(input.userId).map {
      case Some(user) => FindUserOutput.Success(user)
      case None       => FindUserOutput.NotFound(input.userId)
    }
  }
}
