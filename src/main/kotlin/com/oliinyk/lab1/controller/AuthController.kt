package com.oliinyk.lab1.controller

import com.oliinyk.lab1.util.JwtUtil
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val jwtUtil: JwtUtil) {

    @PostMapping("/login")
    fun login(@RequestBody user: AuthRequestBody): Map<String, String> {
        val username = user.username
        val role = user.role
        val token = jwtUtil.generateToken(username, role)
        return mapOf("token" to token)
    }
}

data class AuthRequestBody(
    val username: String,
    val role: String
)

