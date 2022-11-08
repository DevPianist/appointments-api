package com.servall.repositories

import com.servall.models.Appointment
import com.servall.models.Availability
import com.servall.models.Role
import com.servall.models.User

object BarbershopRepository {

    val users = mutableListOf(
        User(
            userId = "1",
            fullName = "Angel Vazquez",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            userName = "angel.vazquez",
            role = Role.BARBER
        ),
        User(
            userId = "2",
            fullName = "Felipe Cisneros",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            userName = "felipe.cisneros",
            role = Role.BARBER
        ),
        User(
            userId = "3",
            fullName = "Marc Suarez",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            userName = "marc.suarez",
            role = Role.CUSTOMER
        ),
        User(
            userId = "4",
            fullName = "Pablo Lloret",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            userName = "pablo.llore",
            role = Role.CUSTOMER
        )
    )

    val availability = mutableListOf(
        Availability(
            weekDayRange = "1-7",
            hourRange = "9-18",
            available = true,
            user = users[0] //Angel
        ),
        Availability(
            weekDayRange = "1-5",
            hourRange = "10-19",
            available = true,
            user = users[1] //Felipe
        )
    )

    val appointments = mutableSetOf<Appointment>()

}