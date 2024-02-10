package com.example.modules.database


import com.example.model.config.Config
import jakarta.inject.Singleton
import org.flywaydb.core.Flyway
import org.flywaydb.core.api.output.MigrateResult


@Singleton
class FlywayImpl(
	private val cfg: Config,
) {

	private val instance: Flyway by lazy {

		Flyway.configure()
			.loggers("slf4j")
			.dataSource(
				cfg.db.postgres.jdbcUrl,
				cfg.db.postgres.user,
				cfg.db.postgres.password
			)
			.locations("classpath:db/migration")
			.load()
	}

	fun migrate(): MigrateResult = instance.migrate()
}