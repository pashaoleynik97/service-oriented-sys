package com.oliinyk.lab1.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false, unique = true)
    val email: String = ""
) : Serializable