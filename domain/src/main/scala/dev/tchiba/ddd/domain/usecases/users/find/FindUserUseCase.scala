package dev.tchiba.ddd.domain.usecases.users.find

import dev.tchiba.ddd.domain.usecases.UseCase

import scala.concurrent.Future

abstract class FindUserUseCase extends UseCase[FindUserInput, FindUserOutput, Future]
