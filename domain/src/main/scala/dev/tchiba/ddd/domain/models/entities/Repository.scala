package dev.tchiba.ddd.domain.models.entities

/**
 * リポジトリの責務を表現するマーカー `trait`
 *
 * @note `Repository` は集約に対する操作なので、[[Aggregate]] がミックスインされている [[Entity]] に対してのみ作成できる。
 * @tparam E [[Aggregate]]を継承している[[Entity]]
 */
trait Repository[E <: Aggregate]
