package dev.tchiba.ddd.domain.usecases.users.list

import dev.tchiba.ddd.domain.usecases.UseCase

import scala.concurrent.Future

abstract class ListUsersUseCase extends UseCase[ListUsersInput, ListUsersOutput, Future]
