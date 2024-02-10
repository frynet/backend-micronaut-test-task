package com.example.app.dto.response

import com.example.model.domain.SchoolSubject
import com.fasterxml.jackson.annotation.JsonProperty


data class ResponseStudentInfo(
	val name: String,

	@get:JsonProperty("class")
	val clazz: String,

	val stats: Map<SchoolSubject, Int> = emptyMap(),
)