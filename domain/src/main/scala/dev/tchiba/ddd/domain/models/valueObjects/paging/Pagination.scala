package dev.tchiba.ddd.domain.models.valueObjects.paging

import dev.tchiba.ddd.domain.models.valueObjects.ValueObject

case class Pagination(page: Int, perPage: Int) extends ValueObject {
  require(
    page >= 1 && perPage >= 1,
    s"`page` and `perPage` must be greater than or equal to 1. but `page` is $page, `perPage` is $perPage"
  )

  val limit: Int  = perPage
  val offset: Int = (page - 1) * perPage
}
