package com.devpianist.models

import kotlinx.serialization.Serializable

@Serializable
data class Interview(
    val id: String,
    val dateTime: Long,
    var status: Status,
    var candidateQualification: Int?,
    val interviewer: Interviewer,
    val jobDescription: JobDescription,
    val candidate: User
) {
    enum class Status {
        CREATED, ACCEPTED, REJECTED, FINISHED
    }
}
