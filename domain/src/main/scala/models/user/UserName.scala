package dev.tchiba.domain
package models.user

case class UserName(value: String) {
  require(value.length >= 3, s"ユーザー名は3文字以上です: $value")
  require(value.length <= 20, s"ユーザー名は20文字以下です: $value")
}
