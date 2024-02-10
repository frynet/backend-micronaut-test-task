package com.example.tests.model


data class GeneratedStudents(
	val students: Map<Int, List<StudGrade>>,
	val classes: Map<String, List<Int>>,
)