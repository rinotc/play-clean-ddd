package dev.tchiba.ddd.domain
package models.entities.user

import models.valueObjects.person.FullName

import scala.concurrent.Future

trait UserRepository {

  protected case class Conflict(userId: UserId)

  def add(user: User): Future[Either[Conflict, UserId]]

  def contains(fullName: FullName): Future[Boolean]
}
