package com.example.app

import com.example.app.StudentApiConst.AVG_GRADES_BY_SUBJECT_BY_CLASS
import com.example.app.StudentApiConst.BASE_PATH
import com.example.app.StudentApiConst.STUDENT
import com.example.app.StudentApiConst.STUDENT_GRADES
import com.example.app.dto.response.ResponseStats
import com.example.app.dto.response.ResponseStudentInfo
import io.micronaut.http.HttpStatus.METHOD_NOT_ALLOWED
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.exceptions.HttpStatusException


@Controller(BASE_PATH)
class StudentApi {

	@Post
	fun addStudent(): Int {

		TODO()
	}

	@Post(STUDENT_GRADES)
	fun addStudentGrade() {
		TODO()
	}

	@Get(STUDENT)
	fun getStudentInfo(): ResponseStudentInfo {

		TODO()
	}

	@Get(AVG_GRADES_BY_SUBJECT_BY_CLASS)
	fun avgGradesBySubjectByClass(): ResponseStats {

		throw HttpStatusException(METHOD_NOT_ALLOWED, "")
	}
}