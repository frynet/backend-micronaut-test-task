package com.example.app


object StudentApiConst {

	const val MODULE = "students"
	const val BASE_PATH = "/$MODULE"

	const val STUDENT_ID = "studID"

	const val MANY = ""
	const val SINGLE = "/{$STUDENT_ID}"

	const val STUDENT = SINGLE
	const val STUDENT_GRADES = "$SINGLE/grades"

	const val AVG_GRADES_BY_SUBJECT_BY_CLASS = "/stats/avg-grades-by-subj-by-class"
}