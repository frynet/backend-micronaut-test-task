package com.example.util

import com.example.app.dto.request.RequestStudentAdd
import com.example.app.dto.request.RequestStudentAddGrade
import com.example.clients.StudentClient
import com.example.model.domain.SchoolSubject
import com.example.tests.model.GeneratedStudents
import com.example.tests.model.StudGrade
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.*
import kotlin.random.Random


@Singleton
class Generate {

	@Inject
	private lateinit var studentClient: StudentClient

	private val gradeSet = setOf(1, 2, 3, 4, 5)
	private val classLetterSet = setOf('A', 'B', 'C', 'D')
	private val classNumberSet = (1..11).map { it }

	private val cntStudInClass: Int
		get() = Random.nextInt(3, 5)


	private val cntGradeForStud: Int
		get() = Random.nextInt(2, 7)

	private fun generateName(): String = UUID.randomUUID().toString().take(5)

	private fun generateClassName(): String {

		return classNumberSet.random().toString() + classLetterSet.random()
	}

	fun student() = RequestStudentAdd(
		generateName(),
		generateClassName(),
	)

	private fun RequestStudentAddGrade.toTestItem() = StudGrade(subject, grade.toFloat())

	fun generateManyStudentsWithGrades(
		countClasses: Int = 3,
	): GeneratedStudents {

		val students = mutableMapOf<Int, List<StudGrade>>()
		val classes = mutableMapOf<String, List<Int>>()

		var studId: Int
		var className: String
		var req: RequestStudentAddGrade

		repeat(countClasses) {

			className = generateClassName()

			classes.getOrPut(className) {

				(1..cntStudInClass).map {

					studId = studentClient.addStudent(
						RequestStudentAdd(generateName(), className)
					)

					students.getOrPut(studId) {

						(1..cntGradeForStud).map {

							req = RequestStudentAddGrade(SchoolSubject.entries.random(), gradeSet.random())
							studentClient.addStudentGrade(studId, req)

							req.toTestItem()
						}
					}

					studId
				}
			}
		}

		return GeneratedStudents(students, classes)
	}
}