package dev.tchiba.domain
package models.valueObjects

trait SingleValueObject[+A] extends ValueObject {
  val value: A
}
