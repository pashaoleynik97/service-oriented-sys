package com.oliinyk.lab1.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtUtil {

    private val secretKey = SecretKeyKeeper.key

    fun generateToken(username: String, role: String): String =
        Jwts.builder()
            .setSubject(username)
            .claim("role", role)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(secretKey)
            .compact()

    fun extractClaims(token: String): Claims =
        Jwts.parser()
            .setSigningKey(secretKey)
            .build()
            .parseSignedClaims(token)
            .payload
}

private object SecretKeyKeeper {
    val key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256)
}