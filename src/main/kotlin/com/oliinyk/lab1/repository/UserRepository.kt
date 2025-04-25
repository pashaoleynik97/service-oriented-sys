package com.oliinyk.lab1.repository

import com.oliinyk.lab1.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {

}