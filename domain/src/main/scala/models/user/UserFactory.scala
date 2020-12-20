package dev.tchiba.domain
package models.user

trait UserFactory {
  def create(name: UserName): User
}
