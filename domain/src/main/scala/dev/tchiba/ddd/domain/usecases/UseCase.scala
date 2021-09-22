package dev.tchiba.ddd.domain.usecases

abstract class UseCase[TInput <: Input[TOutput], TOutput <: Output, F[_]] {
  def handle(input: TInput): F[TOutput]
}
