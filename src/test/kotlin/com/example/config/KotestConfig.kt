package com.example.config

import com.example.containers.PostgresContainer
import io.kotest.core.config.AbstractProjectConfig
import io.micronaut.test.extensions.kotest5.MicronautKotest5Extension


class KotestConfig : AbstractProjectConfig() {

	override fun extensions() = listOf(MicronautKotest5Extension)

	override suspend fun beforeProject() {
		PostgresContainer.start()
	}

	override suspend fun afterProject() {
		PostgresContainer.stop()
	}
}