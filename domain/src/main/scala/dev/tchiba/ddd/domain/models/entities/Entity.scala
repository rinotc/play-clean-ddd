package dev.tchiba.ddd.domain.models.entities

/**
 * DDDのエンティティの責務を表現する `trait`
 *
 * @example
 * {{{
 *   case class SampleId(value: UUID) extends EntityId[UUID]
 *   final class Sample(id: SampleId, value: Int) extends Entity[SampleId] {
 *     override def canEqual(that: Any) = that.isInstanceOf[Sample]
 *   }
 * }}}
 *
 * @tparam ID [[EntityId]]
 * @see 参考：[[https://github.com/j5ik2o/spetstore/blob/master/app/com/github/j5ik2o/spetstore/domain/support/support/Entity.scala]]
 */
trait Entity[ID <: EntityId[_]] {

  /**
   * 識別子の値
   */
  val id: ID

  def canEqual(that: Any): Boolean

  override def equals(obj: Any): Boolean = obj match {
    case that: Entity[_] => that.canEqual(this) && id == that.id
    case _               => false
  }

  override def hashCode(): Int = 31 * id.##
}
