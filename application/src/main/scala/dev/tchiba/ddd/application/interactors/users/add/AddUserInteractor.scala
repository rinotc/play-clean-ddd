package dev.tchiba.ddd.application.interactors.users.add

import dev.tchiba.ddd.domain.models.entities.user.{User, UserRepository}
import dev.tchiba.ddd.domain.usecases.users.add.{AddUserInput, AddUserOutput, AddUserUseCase}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AddUserInteractor @Inject() (userRepository: UserRepository)(implicit ec: ExecutionContext)
    extends AddUserUseCase {
  override def handle(input: AddUserInput): Future[AddUserOutput] = {
    val newUser = User.create(input.name)
    userRepository.add(newUser).map { newUserId => AddUserOutput.Success(newUserId) }
  }
}
