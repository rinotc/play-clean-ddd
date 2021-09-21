package dev.tchiba.ddd.domain
package models.entities.user

import models.entities.Entity
import models.valueObjects.person.FullName

final class User(val id: UserId, val name: FullName) extends Entity[UserId] {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[User]
}
