package dev.tchiba.domain
package models.user

import scala.concurrent.Future

trait UserRepository {
  def find(id: UserId): Future[Option[User]]

  def find(name: UserName): Future[Option[User]]

  def find(ids: Seq[UserId]): Future[Seq[User]]

  def findAll: Future[Seq[User]]

  def save(user: User): Future[Unit]

  def delete(user: User): Future[Unit]
}
