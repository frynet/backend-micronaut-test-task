package com.example

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info


@OpenAPIDefinition(
	info = Info(
		title = "TestTask",
		version = "0.0",
	)
)
object Application {

	@JvmStatic
	fun main(args: Array<String>) {

		Micronaut
			.build(*args)
			.banner(false)
			.start()
	}
}