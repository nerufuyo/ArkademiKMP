package com.example.arkademikmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform