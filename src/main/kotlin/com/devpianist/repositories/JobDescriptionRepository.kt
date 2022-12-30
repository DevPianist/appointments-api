package com.devpianist.repositories

import com.devpianist.models.JobDescription

object JobDescriptionRepository {

    val jobDescriptions = mutableListOf<JobDescription>(
        JobDescription(
            id = "1",
            description = "Kotlin Developer",
            englishRequired = true,
            recruiter = UserRepository.users[0],
            client = ClientRepository.clients[0],
        )
    )
}
