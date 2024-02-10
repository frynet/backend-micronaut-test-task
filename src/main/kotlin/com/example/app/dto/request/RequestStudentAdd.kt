package com.example.app.dto.request

import com.fasterxml.jackson.annotation.JsonProperty


data class RequestStudentAdd(

	val name: String,

	@get:JsonProperty("class")
	val clazz: String,
)