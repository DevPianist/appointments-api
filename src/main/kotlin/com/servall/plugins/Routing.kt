package com.servall.plugins

import com.servall.routes.barbershop.appointmentsRouting
import com.servall.routes.barbershop.barbersRouting
import com.servall.routes.interviews.candidatesRouting
import com.servall.routes.interviews.interviewsRouting
import com.servall.routes.login.loginRouting
import io.ktor.server.application.*

fun Application.configureRouting() {
    loginRouting()
    //interviews
    interviewsRouting()
    candidatesRouting()
    //barbershop
    appointmentsRouting()
    barbersRouting()
}
