package dev.tchiba.ddd.domain
package models.entities.user

import models.entities.{EntityId, EntityIdFactoryUUID}

import java.util.UUID

case class UserId(value: UUID) extends EntityId[UUID]

object UserId extends EntityIdFactoryUUID[UserId]
