package dev.tchiba.domain.models.user

case class User(
    id: UserId,
    name: UserName,
    userType: UserType
)
