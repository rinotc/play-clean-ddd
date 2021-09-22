package dev.tchiba.ddd.infrastructure.rdb

trait PostgresDatabaseConfig extends RdbConfig {
  override protected val configName: String = "postgres"
}
