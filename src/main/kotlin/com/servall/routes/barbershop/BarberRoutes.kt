package com.servall.routes.barbershop

import com.servall.repositories.BarbershopRepository
import com.servall.responses.ErrorResponse
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.barbersRouting() {
    routing {
        listBarbersByAvailability()
    }
}

private fun Route.listBarbersByAvailability() {
    route("/barbers") {
        get {
            val weekDayRange = call.request.queryParameters["weekDayRange"]
            val hourRange = call.request.queryParameters["hourRange"]

            if (weekDayRange.isNullOrEmpty() || hourRange.isNullOrEmpty()) return@get call.respond(
                ErrorResponse(message = "Please check weekDayRange or hourRange")
            )

            val customerHourRange = hourRange.split("-")
            val customerWeekDayRange = weekDayRange.split("-")

            val availability = BarbershopRepository.availability.filter {
                if (it.available.not()) return@filter false

                val barberWeekDayRange = it.weekDayRange.split("-")
                val barberHourRange = it.hourRange.split("-")

                val isDayRangeAvailable =
                    customerWeekDayRange[0].toInt() <= barberWeekDayRange[1].toInt() && barberWeekDayRange[0].toInt() <= customerWeekDayRange[1].toInt()
                val isHourRangeAvailable =
                    customerHourRange[0].toInt() <= barberHourRange[1].toInt() && barberHourRange[0].toInt() <= customerHourRange[1].toInt()

                isDayRangeAvailable && isHourRangeAvailable
            }
            call.respond(availability.map { it.user.copy(password = null) })
        }
    }
}


