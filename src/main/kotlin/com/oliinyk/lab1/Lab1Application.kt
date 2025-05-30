package com.oliinyk.lab1

import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Lab1Application

fun main(args: Array<String>) {
	runApplication<Lab1Application>(*args)
}

@PostConstruct
fun printZipkinConfig() {
	println("Zipkin config: ${System.getenv("SPRING_ZIPKIN_BASE_URL")}")
}
