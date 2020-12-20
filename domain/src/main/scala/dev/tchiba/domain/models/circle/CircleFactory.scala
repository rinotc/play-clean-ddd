package dev.tchiba.domain.models.circle

import dev.tchiba.domain.models.user.UserName

trait CircleFactory {
  def create(name: CircleName, owner: UserName)
}
