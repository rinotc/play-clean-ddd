package dev.tchiba.domain
package models.valueObjects.person

case class FullName(firstName: String, lastName: String) {
  val fullName = s"$lastName $firstName"
}
