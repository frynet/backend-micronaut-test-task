package com.example.model.config

import io.micronaut.context.annotation.Context


@Context
class Config(
	val db: ConfigDatabase,
)