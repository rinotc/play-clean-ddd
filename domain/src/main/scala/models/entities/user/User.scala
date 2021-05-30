package dev.tchiba.ddd.domain
package models.entities.user

import models.entities.Entity
import models.valueObjects.person.FullName

case class User(
    id: UserId,
    name: FullName
) extends Entity
