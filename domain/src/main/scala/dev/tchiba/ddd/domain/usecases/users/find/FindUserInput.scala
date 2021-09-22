package dev.tchiba.ddd.domain.usecases.users.find

import dev.tchiba.ddd.domain.models.entities.user.UserId
import dev.tchiba.ddd.domain.usecases.Input

case class FindUserInput(userId: UserId) extends Input[FindUserOutput]
