package dev.tchiba.domain.models.user

sealed trait UserType

case object Normal extends UserType

case object Premium extends UserType
