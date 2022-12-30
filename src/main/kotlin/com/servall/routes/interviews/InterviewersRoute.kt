package com.servall.routes.interviews

import com.servall.models.Interview
import com.servall.repositories.InterviewsRepository
import com.servall.responses.ErrorResponse
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.interviewsRouting() {
    routing {
        listInterviewersRouteByAvailability()
        getInterviewById()
        createInterview()
        listInterviews()
    }
}

fun Route.listInterviews() {
    get("/interviews") {
        call.respond(InterviewsRepository.interviews)
    }
}

fun Route.createInterview() {
    post("/interview") {
        val interview = call.receive<Interview>()
        InterviewsRepository.interviews.add(interview)
        call.respond(interview)
    }
}

fun Route.getInterviewById() {
    get("/interview/{id}") {
        val id = call.parameters["id"]
        call.respond(InterviewsRepository.interviews.find { it.id == id } ?: ErrorResponse(message = "Interview not found."))
    }
}

fun Route.listInterviewersRouteByAvailability() {
    route("/interviewers") {
        get {
            val weekDayRange = call.request.queryParameters["weekDayRange"]
            val hourRange = call.request.queryParameters["hourRange"]

            if (weekDayRange.isNullOrEmpty() || hourRange.isNullOrEmpty()) return@get call.respond(
                ErrorResponse(message = "Please check weekDayRange or hourRange")
            )

            val candidateHourRange = hourRange.split("-")
            val candidateWeekDayRange = weekDayRange.split("-")

            val availability = InterviewsRepository.availability.filter {
                if (it.available.not()) return@filter false

                val interviewerWeekDayRange = it.weekDayRange.split("-")
                val interviewerHourRange = it.hourRange.split("-")

                val isDayRangeAvailable =
                    candidateWeekDayRange[0].toInt() <= interviewerWeekDayRange[1].toInt() && interviewerWeekDayRange[0].toInt() <= candidateWeekDayRange[1].toInt()
                val isHourRangeAvailable =
                    candidateHourRange[0].toInt() <= interviewerHourRange[1].toInt() && interviewerHourRange[0].toInt() <= candidateHourRange[1].toInt()

                isDayRangeAvailable && isHourRangeAvailable
            }
            call.respond(availability.map { it.user.copy(password = null) })
        }
    }
}

