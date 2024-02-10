val javaVersion = JavaVersion.VERSION_17

val kotlin_version: String by project
val logback_version: String by project
val exposed_sql_version: String by project
val postgres_test_container_version: String by project


version = "0.1"
group = "com.example"

plugins {
	kotlin("jvm") version "1.9.22"
	kotlin("kapt") version "1.9.22"
	kotlin("plugin.allopen") version "1.9.22"

	id("com.github.johnrengelman.shadow") version "8.1.1"
	id("io.micronaut.application") version "4.3.1"
	id("io.micronaut.aot") version "4.3.1"
}

repositories {
	mavenCentral()
}

dependencies {
	// DI
	kapt("io.micronaut:micronaut-inject")

	// micronaut basics
	kapt("io.micronaut:micronaut-http-validation")

	implementation("io.micronaut:micronaut-http-client")
	implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")

	// database - SQL
	implementation("io.micronaut.flyway:micronaut-flyway")
	runtimeOnly("org.flywaydb:flyway-database-postgresql")
	implementation("io.micronaut.sql:micronaut-jdbc-hikari")

	implementation("org.postgresql:postgresql")

	runtimeOnly("org.jetbrains.exposed:exposed-jdbc:$exposed_sql_version")
	implementation("org.jetbrains.exposed:exposed-dao:$exposed_sql_version")
	implementation("org.jetbrains.exposed:exposed-core:$exposed_sql_version")

	// serialization
	implementation("io.micronaut:micronaut-jackson-databind")
	runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

	// documentation
	kapt("io.micronaut.openapi:micronaut-openapi")
	implementation("io.swagger.core.v3:swagger-annotations")
	implementation("io.micronaut.views:micronaut-views-thymeleaf")

	// logging
	implementation("ch.qos.logback:logback-classic")

	// testing
	testImplementation("org.testcontainers:postgresql:$postgres_test_container_version")
}

application {
	mainClass.set("com.example.Application")
}
java {
	sourceCompatibility = javaVersion
}

kotlin {
	jvmToolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

tasks {
	compileKotlin {
		kotlinOptions {
			jvmTarget = javaVersion.toString()
		}
	}

	compileTestKotlin {
		kotlinOptions {
			jvmTarget = javaVersion.toString()
		}
	}
}

graalvmNative.toolchainDetection.set(false)
micronaut {
	runtime("netty")
	testRuntime("kotest5")
	processing {
		incremental(true)
		annotations("com.example.*")
	}

	aot {
		optimizeServiceLoading.set(false)
		convertYamlToJava.set(false)
		precomputeOperations.set(true)
		cacheEnvironment.set(true)
		optimizeClassLoading.set(true)
		deduceEnvironment.set(true)
		optimizeNetty.set(true)
	}
}