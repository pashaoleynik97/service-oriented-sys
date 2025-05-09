package com.oliinyk.lab1.svc

import com.oliinyk.lab1.entity.UserEntity
import com.oliinyk.lab1.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(user: UserEntity): UserEntity =
        userRepository.save(user)

    fun getAllUsers(): List<UserEntity> =
        userRepository.findAll()

    fun getUserById(id: Long): UserEntity? =
        userRepository.findById(id).orElse(null)

    @Transactional
    fun updateUser(id: Long, updatedUser: UserEntity): UserEntity? {
        val existingUser = userRepository.findById(id).orElse(null)
        return if (existingUser != null) {
            val userToSave = existingUser.copy(
                name = updatedUser.name,
                email = updatedUser.email
            )
            userRepository.save(userToSave)
        } else {
            null
        }
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}