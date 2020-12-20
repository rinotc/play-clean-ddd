package dev.tchiba.domain
package models.circle

import scala.concurrent.Future

trait CircleRepository {
  def find(id: CircleId): Future[Option[Circle]]

  def find(name: CircleName): Future[Option[Circle]]

  def findAll: Future[Seq[Circle]]

  def save(circle: Circle): Future[Unit]

  def delete(circle: Circle): Future[Unit]
}
