package dev.tchiba.ddd.domain
package models.valueObjects

@deprecated trait SingleValueObject[+A] extends ValueObject {
  val value: A
}
