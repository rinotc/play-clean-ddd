package dev.tchiba.ddd.domain.models.entities

trait EntityId[+A] {
  val value: A
}
