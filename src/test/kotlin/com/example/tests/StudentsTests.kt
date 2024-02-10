package com.example.tests

import com.example.clients.StudentClient
import com.example.tests.model.GeneratedStudents
import com.example.util.Generate
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.StringSpec
import io.micronaut.http.HttpStatus.METHOD_NOT_ALLOWED
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import jakarta.inject.Inject


@MicronautTest
class StudentsTests : StringSpec() {

	@Inject
	private lateinit var generate: Generate

	@Inject
	private lateinit var studentClient: StudentClient


	private val data: GeneratedStudents by lazy { generate.generateManyStudentsWithGrades() }

	private inline fun <reified T> handleIfImplemented(request: () -> T, handle: (T) -> Unit) {

		val response = try {
			request.invoke()
		} catch (ex: HttpClientResponseException) {
			if (ex.status == METHOD_NOT_ALLOWED) null
			else throw ex
		} catch (ex: Throwable) {
			throw ex
		}

		response?.let(handle)
	}

	init {
		"Create student" {
			TODO("Write test logic here")
		}

		"Add grades for student" {
			TODO("Write test logic here")
		}

		"Get student info" {
			TODO("Write test logic here")
		}

		"Average grade per subject per class" {

			shouldNotThrowAny {
				handleIfImplemented(
					request = {
						studentClient.avgGradesBySubjectByClass()
					}
				) { (response) ->

					TODO("Write test logic here")
				}
			}
		}
	}
}