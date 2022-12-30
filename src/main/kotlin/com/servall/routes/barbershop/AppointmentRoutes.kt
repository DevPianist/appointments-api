package com.servall.routes.barbershop

import com.servall.models.Appointment
import com.servall.models.AppointmentDto
import com.servall.repositories.BarbershopRepository
import com.servall.responses.ErrorResponse
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.appointmentsRouting() {
    routing {
        createAppointment()
        listAppointments()
        getAppointmentById()
    }
}

private fun Route.getAppointmentById() {
    get("/appointment/{id}") {
        val id = call.parameters["id"]
        call.respond(BarbershopRepository.appointments.find { it.id == id }
            ?: ErrorResponse(message = "Appointment not found."))
    }
}

private fun Route.listAppointments() {
    get("/customer/{userId}/appointments") {
        val customerId = call.parameters["userId"]
        call.respond(
            BarbershopRepository.appointments
                .filter { it.clientId == customerId }
                .map { appointment ->
                    AppointmentDto(
                        id = appointment.id,
                        datetime = appointment.datetime,
                        barber = BarbershopRepository.users.find { it.id == appointment.barberId }!!,
                        customer = BarbershopRepository.users.find { it.id == appointment.clientId }!!,
                    )
                }
        )
    }
}

fun Route.createAppointment() {
    post("/appointment") {
        val appointment = call.receive<Appointment>()
        BarbershopRepository.appointments.add(
            appointment.copy(
                id = (BarbershopRepository.appointments.size + 1).toString()
            )
        )
        call.respond(
            AppointmentDto(
                id = appointment.id,
                datetime = appointment.datetime,
                barber = BarbershopRepository.users.find { it.id == appointment.barberId }!!,
                customer = BarbershopRepository.users.find { it.id == appointment.clientId }!!
            )
        )
    }
}
