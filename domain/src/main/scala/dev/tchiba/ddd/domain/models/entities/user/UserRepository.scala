package dev.tchiba.ddd.domain
package models.entities.user

import dev.tchiba.ddd.domain.models.entities.Repository

import scala.concurrent.Future

trait UserRepository extends Repository[User] {

  def add(user: User): Future[UserId]
}
