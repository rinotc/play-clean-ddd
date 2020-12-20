package dev.tchiba.domain
package models.user

case class User(
    id: UserId,
    name: UserName,
    userType: UserType
)
