package com.example.app.dto.response

import com.example.model.domain.SchoolSubject


data class ResponseStats(
	val data: Map<String, Map<SchoolSubject, Int>>,
)