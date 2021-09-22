package dev.tchiba.ddd.domain.usecases

case class Sync[TOutput <: Output](result: TOutput)
