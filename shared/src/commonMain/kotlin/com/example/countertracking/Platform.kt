package com.example.countertracking

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform