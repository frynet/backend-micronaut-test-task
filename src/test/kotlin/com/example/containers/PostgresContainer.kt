package com.example.containers

import org.slf4j.LoggerFactory
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.output.Slf4jLogConsumer
import org.testcontainers.utility.DockerImageName


class PostgresContainer : PostgreSQLContainer<PostgresContainer>(
	DockerImageName.parse("postgres:14-alpine")
) {

	companion object {

		private val instance = PostgresContainer()
		private val log = LoggerFactory.getLogger("PostgresContainer")
		private val logConsumer = Slf4jLogConsumer(log)

		fun start() {
			if (instance.isRunning.not()) {
				instance.start()
				// instance.followOutput(logConsumer)

				System.setProperty("db.postgres.user", instance.username)
				System.setProperty("db.postgres.jdbcUrl", instance.jdbcUrl)
				System.setProperty("db.postgres.password", instance.password)
			}
		}

		fun stop() {
			if (instance.isRunning) {
				instance.stop()
			}
		}
	}
}