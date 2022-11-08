package com.servall.routes.login

import com.servall.dto.LoginDto
import com.servall.repositories.BarbershopRepository
import com.servall.repositories.InterviewsRepository
import com.servall.responses.ErrorResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.loginRouting() {
    routing {
        interviewsLoginRoute()
        barbershopLoginRoute()
    }
}

fun Route.barbershopLoginRoute() {
    route("/barbershop/login") {
        post {
            val login = call.receive<LoginDto>()
            val user = BarbershopRepository.users.find { it.userName.trim() == login.userName.trim() && it?.password == login.password }
            if (user != null) {
                call.respond(user.copy(password = null))
            } else {
                call.respond(ErrorResponse(message = "Verify your user name and password!"))
            }
        }
    }
}

fun Route.interviewsLoginRoute() {
    route("/interviews/login") {
        post {
            val login = call.receive<LoginDto>()
            val user = InterviewsRepository.users.find { it.userName.trim() == login.userName && it.password?.trim() == login.password }
            if (user != null) {
                call.respond(user.copy(password = null))
            } else {
                call.respond(ErrorResponse(message = "Verify your user name and password!"))
            }
        }
    }
}