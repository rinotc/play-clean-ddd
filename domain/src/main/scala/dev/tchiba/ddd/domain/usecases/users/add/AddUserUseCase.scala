package dev.tchiba.ddd.domain.usecases.users.add

import dev.tchiba.ddd.domain.usecases.UseCase

import scala.concurrent.Future

abstract class AddUserUseCase extends UseCase[AddUserInput, AddUserOutput, Future]
