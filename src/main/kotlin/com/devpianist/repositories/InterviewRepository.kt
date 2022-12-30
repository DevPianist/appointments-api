package com.devpianist.repositories

import com.devpianist.models.Interview

object InterviewRepository {
    val interviews = mutableListOf<Interview>(
        Interview(
            id = "1",
            dateTime = 1620000000000,
            status = Interview.Status.CREATED,
            candidateQualification = null,
            interviewer = InterviewerRepository.interviewers[0],
            jobDescription = JobDescriptionRepository.jobDescriptions[0],
            candidate = UserRepository.users[4]
        )
    )
}