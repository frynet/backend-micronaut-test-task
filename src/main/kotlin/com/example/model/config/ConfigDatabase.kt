package com.example.model.config

import io.micronaut.context.annotation.ConfigurationProperties


@ConfigurationProperties("db")
interface ConfigDatabase {

	@ConfigurationProperties("postgres")
	interface ConfigPostgres {

		val user: String
		val password: String

		val maxPoolSize: Int
		val jdbcUrl: String
		val jdbcDriver: String
	}

	val postgres: ConfigPostgres
}