package dev.tchiba.ddd.application.interactors.users.list

import dev.tchiba.ddd.domain.models.entities.user.UserRepository
import dev.tchiba.ddd.domain.usecases.users.list.{ListUsersInput, ListUsersOutput, ListUsersUseCase}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class ListUsersInteractor @Inject() (userRepository: UserRepository)(implicit ec: ExecutionContext)
    extends ListUsersUseCase {

  override def handle(input: ListUsersInput): Future[ListUsersOutput] = {
    userRepository.list(input.pagination).map { users => ListUsersOutput.Success(users) }
  }
}
