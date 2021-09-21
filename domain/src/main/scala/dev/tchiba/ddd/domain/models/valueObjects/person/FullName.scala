package dev.tchiba.ddd.domain
package models.valueObjects.person

case class FullName(firstName: String, lastName: String) {
  val fullName = s"$lastName $firstName"
}
