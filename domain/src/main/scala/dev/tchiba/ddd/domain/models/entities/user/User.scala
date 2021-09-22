package dev.tchiba.ddd.domain
package models.entities.user

import models.entities.{Aggregate, Entity}
import models.valueObjects.person.FullName

final class User(val id: UserId, val name: FullName) extends Entity[UserId] with Aggregate {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[User]
}

object User {
  def create(name: FullName) = new User(UserId.generate, name)
}
