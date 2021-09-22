package dev.tchiba.ddd.domain.usecases.users.add

import dev.tchiba.ddd.domain.models.entities.user.UserId
import dev.tchiba.ddd.domain.usecases.Output

sealed abstract class AddUserOutput extends Output
object AddUserOutput {
  case class Success(userId: UserId) extends AddUserOutput
}
