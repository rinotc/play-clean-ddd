package dev.tchiba.ddd.domain
package models.entities.user

import dev.tchiba.ddd.domain.models.entities.Repository
import dev.tchiba.ddd.domain.models.valueObjects.paging.Pagination

import scala.concurrent.Future

trait UserRepository extends Repository[User] {

  def list(pagination: Pagination): Future[Seq[User]]

  def find(id: UserId): Future[Option[User]]

  def add(user: User): Future[UserId]
}
