package dev.tchiba.ddd.domain.usecases.users.list

import dev.tchiba.ddd.domain.models.valueObjects.paging.Pagination
import dev.tchiba.ddd.domain.usecases.Input

case class ListUsersInput(pagination: Pagination) extends Input[ListUsersOutput]
