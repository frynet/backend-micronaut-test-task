package com.example.app.dto.request

import com.example.model.domain.SchoolSubject


data class RequestStudentAddGrade(
	val subject: SchoolSubject,
	val grade: Int,
)