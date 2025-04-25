package com.oliinyk.lab1.controller

import com.oliinyk.lab1.entity.UserEntity
import com.oliinyk.lab1.svc.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody user: UserEntity): ResponseEntity<UserEntity> =
        ResponseEntity.ok(userService.createUser(user))

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserEntity>> =
        ResponseEntity.ok(userService.getAllUsers())

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserEntity> =
        userService.getUserById(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody user: UserEntity
    ): ResponseEntity<UserEntity> =
        userService.updateUser(id, user)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }
}