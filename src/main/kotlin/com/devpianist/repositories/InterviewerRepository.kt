package com.devpianist.repositories

import com.devpianist.models.Interviewer

object InterviewerRepository {

    val interviewers = mutableListOf<Interviewer>(
        Interviewer(
            id = "1",
            weekDayRange = "1-5",
            hourRange = "9-18",
            available = true,
            user = UserRepository.users[1],
        ),
        Interviewer(
            id = "2",
            weekDayRange = "1-5",
            hourRange = "9-18",
            available = true,
            user = UserRepository.users[2],
        )
    )
}