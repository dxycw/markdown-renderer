package com.dxyc.markdown.renderer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform