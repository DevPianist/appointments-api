package com.devpianist.routes

import com.devpianist.dto.InterviewDto
import com.devpianist.models.Interview
import com.devpianist.repositories.InterviewRepository
import com.devpianist.repositories.InterviewerRepository
import com.devpianist.repositories.JobDescriptionRepository
import com.devpianist.repositories.UserRepository
import com.servall.models.Role
import com.servall.responses.ErrorResponse
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.interviewsRouting() {
    routing {
        createInterview()
        findAllInterviews()
        findByInterviewId()
        findByInterviewerId()
        findByCandidateId()
        rejectInterview()
        acceptInterview()
        finishInterview()
        findAllInterviewers()
        findAllCandidates()
    }
}

fun Route.createInterview() {
    post("/interview") {
        val interview = call.receive<InterviewDto>()
        try {
            InterviewRepository.interviews.add(
                Interview(
                    id = (InterviewRepository.interviews.size + 1).toString(),
                    dateTime = interview.dateTime,
                    status = Interview.Status.CREATED,
                    candidateQualification = null,
                    interviewer = InterviewerRepository.interviewers.find { it.id == interview.interviewerId }!!
                        .takeIf { it.user.role == Role.INTERVIEWER }!!,
                    jobDescription = JobDescriptionRepository.jobDescriptions.find { it.id == interview.jobDescriptionId }!!,
                    candidate = UserRepository.users.find { it.id == interview.candidateId && it.role == Role.CANDIDATE }!!
                )
            )
            call.respond(interview)
        } catch (e: Exception) {
            call.respond(ErrorResponse(message = "Interviewer or candidate not found"))
        }
    }
}

fun Route.findAllInterviews() {
    get("/interviews") {
        call.respond(InterviewRepository.interviews)
    }
}


fun Route.findByInterviewId() {
    get("/interview/{id}") {
        val id = call.parameters["id"]
        call.respond(InterviewRepository.interviews.find { it.id == id }
            ?: ErrorResponse(message = "Interview not found"))
    }
}

fun Route.findByInterviewerId() {
    get("/interview/interviewer/{id}") {
        val interviewerId = call.parameters["id"]
        call.respond(InterviewRepository.interviews.filter { it.interviewer.id == interviewerId })
    }
}

fun Route.findByCandidateId() {
    get("/interview/candidate/{id}") {
        val candidateId = call.parameters["id"]
        call.respond(InterviewRepository.interviews.filter { it.candidate.id == candidateId })
    }
}

fun Route.rejectInterview() {
    get("/interview/reject/{id}") {
        val id = call.parameters["id"]
        InterviewRepository.interviews.forEach {
            if (it.id == id) {
                it.status = Interview.Status.REJECTED
            }
        }
        call.respond(InterviewRepository.interviews.find { it.id == id }
            ?: ErrorResponse(message = "Interview not found."))
    }
}

fun Route.acceptInterview() {
    get("/interview/accept/{id}") {
        val id = call.parameters["id"]
        InterviewRepository.interviews.forEach {
            if (it.id == id) {
                it.status = Interview.Status.ACCEPTED
            }
        }
        call.respond(InterviewRepository.interviews.find { it.id == id }
            ?: ErrorResponse(message = "Interview not found."))
    }
}

fun Route.finishInterview() {
    get("/interview/finish/{id}") {
        try {
            val id = call.parameters["id"]
            val qualification = call.request.queryParameters["qualification"]
            if (qualification == null) {
                call.respond(ErrorResponse(message = "Qualification is required"))
            } else {
                InterviewRepository.interviews.forEach {
                    if (it.id == id) {
                        it.status = Interview.Status.FINISHED
                        it.candidateQualification = qualification!!.toInt()
                    }
                }
                call.respond(InterviewRepository.interviews.find { it.id == id }
                    ?: ErrorResponse(message = "Interview not found."))
            }
        } catch (e: Exception) {
            call.respond(ErrorResponse(message = "Interview not found."))
        }
    }
}

fun Route.findAllInterviewers() {
    get("/interviewers") {
        val interviewers = InterviewerRepository.interviewers
        call.respond(interviewers)
    }
}

fun Route.findAllCandidates() {
    get("/candidates") {
        val candidates = UserRepository.users.filter { it.role == Role.CANDIDATE }
        call.respond(candidates)
    }
}