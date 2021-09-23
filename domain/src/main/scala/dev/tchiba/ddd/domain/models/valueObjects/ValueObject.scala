package dev.tchiba.ddd.domain
package models.valueObjects

/**
 * DDDの値オブジェクトを示すマーカー `trait`
 *
 * ==値オブジェクトの特徴==
 * <ul>
 *  <li>不変である</li>
 *  <li>交換が可能である</li>
 *  <li>等価性によって比較される</li>
 * </ul>
 *
 * @example
 * {{{
 *   case class FullName(firstName: String, lastName: String) extends ValueObject
 * }}}
 */
trait ValueObject
