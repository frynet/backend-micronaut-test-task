package com.example.clients

import com.example.app.StudentApiConst.AVG_GRADES_BY_SUBJECT_BY_CLASS
import com.example.app.StudentApiConst.BASE_PATH
import com.example.app.StudentApiConst.STUDENT
import com.example.app.StudentApiConst.STUDENT_GRADES
import com.example.app.StudentApiConst.STUDENT_ID
import com.example.app.dto.request.RequestStudentAdd
import com.example.app.dto.request.RequestStudentAddGrade
import com.example.app.dto.response.ResponseStats
import com.example.app.dto.response.ResponseStudentInfo
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client


@Client(BASE_PATH)
interface StudentClient {

	@Post
	fun addStudent(@Body request: RequestStudentAdd): Int

	@Post(STUDENT_GRADES)
	fun addStudentGrade(
		@PathVariable(STUDENT_ID) id: Int,
		@Body request: RequestStudentAddGrade
	)

	@Get(STUDENT)
	fun getStudentInfo(@PathVariable(STUDENT_ID) id: Int): ResponseStudentInfo

	@Get(AVG_GRADES_BY_SUBJECT_BY_CLASS)
	fun avgGradesBySubjectByClass(): ResponseStats
}