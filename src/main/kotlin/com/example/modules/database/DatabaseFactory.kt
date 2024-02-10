package com.example.modules.database

import io.micronaut.context.annotation.Context
import jakarta.annotation.PostConstruct


@Context
class DatabaseFactory(
	private val flyway: FlywayImpl,
	private val postgres: PostgresFactory,
) {

	@PostConstruct
	fun connect() {
		postgres.connect()

		flyway.migrate()
	}
}