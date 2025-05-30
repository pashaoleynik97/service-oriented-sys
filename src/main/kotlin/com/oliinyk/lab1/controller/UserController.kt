package com.oliinyk.lab1.controller

import com.oliinyk.lab1.entity.UserEntity
import com.oliinyk.lab1.svc.UserService
import org.slf4j.LoggerFactory
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

    private val log = LoggerFactory.getLogger(UserController::class.java)

    @PostMapping
    fun createUser(@RequestBody user: UserEntity): ResponseEntity<UserEntity> {
        log.info("createUser($user)")
        return ResponseEntity.ok(userService.createUser(user))
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserEntity>> {
        log.info("getAllUsers()")
        return ResponseEntity.ok(userService.getAllUsers())
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserEntity> {
        log.info("getUserById(id=$id)")
        return userService.getUserById(id)
            ?.let {
                log.info("getUserById -> User found: $it")
                ResponseEntity.ok(it)
            }
            ?: run {
                log.warn("getUserById -> User with id=$id not found")
                ResponseEntity.notFound().build()
            }
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody user: UserEntity
    ): ResponseEntity<UserEntity> {
        log.info("updateUser(id=$id, user=$user)")
        return userService.updateUser(id, user)
            ?.let {
                log.info("updateUser -> User updated: $it")
                ResponseEntity.ok(it)
            }
            ?: run {
                log.warn("updateUser -> Failed to update: user with id=$id not found")
                ResponseEntity.notFound().build()
            }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        log.info("deleteUser(id=$id)")
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }
}