package dev.tchiba.ddd.domain
package models.entities.user

import models.entities.EntityId

import java.util.UUID

case class UserId(value: UUID) extends EntityId[UUID]

object UserId {
  def generate: UserId = new UserId(UUID.randomUUID())
}
