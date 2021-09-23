package dev.tchiba.ddd.domain.models.entities

/**
 * DDDのエンティティの責務を表現する `trait`
 *
 * ==エンティティの特徴==
 * <ul>
 *   <li>可変である</li>
 *   <li>同じ属性であっても区別される</li>
 *   <li>同一性により区別される</li>
 * </ul>
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

  // 31を掛ける理由は、Effective Java第3版ではp.54に載っている。
  // > 乗数31は、それが奇数の素数なので選ばれています。もし、その乗数が偶数で乗算がオーバーフローしたら、
  // > 2を掛けることはシフトすることと同じなので情報が失われます。素数を使う利点はあまり明確ではありませんが、素数が伝統的です。
  // > 31の素晴らしい特性は、良いパフォーマンスを得るために、アーキテクチャによって乗算がシフトと減算に置き換えられることです。
  override def hashCode(): Int = 31 * id.##
}
