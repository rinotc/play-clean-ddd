package dev.tchiba.ddd.domain.usecases.users.list

import dev.tchiba.ddd.domain.models.entities.user.User
import dev.tchiba.ddd.domain.usecases.Output

sealed abstract class ListUsersOutput extends Output
object ListUsersOutput {
  case class Success(users: Seq[User]) extends ListUsersOutput
}
