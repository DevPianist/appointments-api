package com.servall

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.servall.plugins.*
import io.ktor.server.application.Application

//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureSerialization()
    configureRouting()
}

fun main() {
    embeddedServer(Netty, port = (System.getenv("PORT") ?: "8080").toInt(), host = "127.0.0.1") {
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
