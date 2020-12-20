package dev.tchiba.domain
package models.circle

import models.user.UserName

trait CircleFactory {
  def create(name: CircleName, owner: UserName): Circle
}
