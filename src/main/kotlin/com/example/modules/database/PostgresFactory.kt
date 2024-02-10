package com.example.modules.database


import com.example.model.config.Config
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import jakarta.inject.Singleton
import org.jetbrains.exposed.sql.Database


@Singleton
class PostgresFactory(
	private val cfg: Config,
) {

	private fun hikariPool(): HikariDataSource {

		val hikariConfig = HikariConfig().also { hikari ->

			with(cfg.db.postgres) {
				hikari.jdbcUrl = jdbcUrl
				hikari.username = user
				hikari.password = password
				hikari.maximumPoolSize = maxPoolSize
				hikari.driverClassName = jdbcDriver
			}

			hikari.isAutoCommit = false
			hikari.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
		}

		hikariConfig.validate()

		return HikariDataSource(hikariConfig)
	}

	fun connect() {
		Database.connect(hikariPool())
	}
}