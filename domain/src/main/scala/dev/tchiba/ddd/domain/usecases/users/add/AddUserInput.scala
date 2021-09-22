package dev.tchiba.ddd.domain.usecases.users.add

import dev.tchiba.ddd.domain.models.valueObjects.person.FullName
import dev.tchiba.ddd.domain.usecases.Input

case class AddUserInput(name: FullName) extends Input[AddUserOutput]
