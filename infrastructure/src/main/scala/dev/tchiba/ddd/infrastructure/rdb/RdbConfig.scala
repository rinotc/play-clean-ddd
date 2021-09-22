package dev.tchiba.ddd.infrastructure.rdb

import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

trait RdbConfig {
  protected val configName: String

  private lazy val dbConfig  = DatabaseConfig.forConfig[JdbcProfile](configName)
  protected lazy val db      = dbConfig.db
  protected lazy val profile = dbConfig.profile
}
