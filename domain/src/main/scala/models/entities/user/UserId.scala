package dev.tchiba.ddd.domain
package models.entities.user

import models.entities.EntityId

import wvlet.airframe.ulid.ULID

case class UserId(value: ULID) extends EntityId

object UserId {
  def generate: UserId = new UserId(ULID.newULID)
}
