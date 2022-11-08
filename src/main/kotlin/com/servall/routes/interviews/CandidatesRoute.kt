package com.servall.routes.interviews

import com.servall.repositories.InterviewsRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.candidatesRouting() {
    routing {
        listCandidates()
    }
}

fun Route.listCandidates() {
    route("/candidates") {
        get {
            call.respond(InterviewsRepository.candidates)
        }
    }
}