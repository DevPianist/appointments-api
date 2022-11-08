package com.servall.repositories

import com.servall.models.*

object InterviewsRepository {

    val users = mutableListOf(
        User(
            userId = "1",
            fullName = "José García Urrútia",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            userName = "jose.garcia",
            role = Role.INTERVIEWER
        ),
        User(
            userId = "2",
            fullName = "Wilson Castiblanco Quintero",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            userName = "wilson.castiblanco",
            role = Role.INTERVIEWER
        ),
        User(
            userId = "3",
            fullName = "Teresa Morales",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            userName = "teresa.morales",
            role = Role.RECRUITER
        ),
        User(
            userId = "4",
            fullName = "Candelaria DeFerrari",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            userName = "candelaria.deferrari",
            role = Role.RECRUITER
        )
    )


    val interviews = mutableSetOf<Interview>()

    val availability = mutableListOf(
        Availability(
            weekDayRange = "1-3",
            hourRange = "15-18",
            available = true,
            user = users[0] // José
        ),
        Availability(
            weekDayRange = "4-5",
            hourRange = "9-11",
            available = true,
            user = users[1] // Wilson
        ),
    )

    val candidates = mutableListOf(
        Candidate(
            id = "1",
            fullName = "Carolina Bustamante",
            requiredSkills = listOf(Skill.KOTLIN, Skill.JAVA, Skill.ANDROID),
            client = "Google",
            englishRequired = true,
            weekDayRange = "1-5",
            hourRange = "15-18"
        ),
        Candidate(
            id = "2",
            fullName = "Luisa Torrejon",
            requiredSkills = listOf(Skill.KOTLIN, Skill.JAVA, Skill.ANDROID),
            client = "AirBnB",
            englishRequired = true,
            weekDayRange = "1-5",
            hourRange = "15-18"
        ),
        Candidate(
            id = "3",
            fullName = "Carlos Franco",
            requiredSkills = listOf(Skill.KOTLIN, Skill.JAVA, Skill.ANDROID),
            client = "Banco ABC",
            englishRequired = false,
            weekDayRange = "1-5",
            hourRange = "15-18"
        )
    )


}