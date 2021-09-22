package dev.tchiba.ddd.domain.models.entities

import java.util.UUID

trait EntityIdFactory[U, ID <: EntityId[U]] {
  def apply(value: U): ID

  def generate: ID

  type FT
  def from(value: FT): ID
}

trait EntityIdFactoryUUID[ID <: EntityId[UUID]] extends EntityIdFactory[UUID, ID] {

  override def generate: ID = apply(UUID.randomUUID())

  override type FT = String

  override def from(value: String): ID = apply(UUID.fromString(value))
}

trait EntityIdFactoryLong[ID <: EntityId[Long]] extends EntityIdFactory[Long, ID] {
  override def generate: ID = apply(-1L)

  override type FT = Long

  override def from(value: Long): ID = apply(value)
}
