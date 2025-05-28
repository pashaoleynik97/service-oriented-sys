package com.oliinyk.lab1.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtUtil {

    private val secretKey = "9ACFD5FCD6C7DDF2BED1F94588E4B"

    fun generateToken(username: String, role: String): String =
        Jwts.builder()
            .setSubject(username)
            .claim("role", role)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact()

    fun extractClaims(token: String): Claims =
        Jwts.parser()
            .setSigningKey(secretKey)
            .build()
            .parseSignedClaims(token)
            .payload
}