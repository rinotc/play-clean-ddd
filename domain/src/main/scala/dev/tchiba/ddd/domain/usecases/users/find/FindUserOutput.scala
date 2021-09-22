package dev.tchiba.ddd.domain.usecases.users.find

import dev.tchiba.ddd.domain.models.entities.user.{User, UserId}
import dev.tchiba.ddd.domain.usecases.Output

sealed abstract class FindUserOutput extends Output
object FindUserOutput {
  case class Success(user: User)  extends FindUserOutput
  case class NotFound(id: UserId) extends FindUserOutput
}
