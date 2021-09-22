package dev.tchiba.ddd.di.modules

import com.google.inject.AbstractModule
import dev.tchiba.ddd.application.interactors.users.add.AddUserInteractor
import dev.tchiba.ddd.domain.models.entities.user.UserRepository
import dev.tchiba.ddd.domain.usecases.users.add.AddUserUseCase
import dev.tchiba.ddd.infrastructure.repository.DefaultUserRepository
import net.codingwell.scalaguice.ScalaModule

class AppModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    bind[AddUserUseCase].to[AddUserInteractor]
    bind[UserRepository].to[DefaultUserRepository]
  }
}
