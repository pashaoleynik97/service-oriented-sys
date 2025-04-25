package com.oliinyk.lab1.controller

import com.oliinyk.lab1.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    private val users = mutableListOf<User>()

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        users.add(user)
        return user
    }

    @GetMapping
    fun getUsers(): List<User> {
        return users
    }

}