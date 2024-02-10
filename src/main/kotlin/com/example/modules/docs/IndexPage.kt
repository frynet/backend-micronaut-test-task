package com.example.modules.docs

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.View
import io.swagger.v3.oas.annotations.Hidden


@Hidden
@Controller
class StartPage {

	@Get
	@View("/docs/index.html")
	fun index(): HttpResponse<Any> {

		return HttpResponse.ok(
			mapOf(
				"swagger" to "/swagger-ui/",
				"redoc" to "/redoc/",
			)
		)
	}
}