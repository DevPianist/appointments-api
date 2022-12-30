package com.devpianist.repositories

import com.devpianist.models.User
import com.servall.models.Role

object UserRepository {

    val users = mutableListOf<User>(
        User(
            id = "1",
            userName = "recruiter",
            fullName = "Teresa Morales",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            token = "",
            role = Role.RECRUITER
        ),
        User(
            id = "2",
            userName = "interviewer1",
            fullName = "José García Urrútia",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            token = "",
            role = Role.INTERVIEWER
        ),
        User(
            id = "3",
            userName = "interviewer2",
            fullName = "Wilson Castiblanco Quintero",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            token = "",
            role = Role.INTERVIEWER
        ),
        User(
            id = "4",
            userName = "devpianist",
            fullName = "Sandro Delgadillo",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            token = "",
            role = Role.CANDIDATE
        ),
        User(
            id = "5",
            userName = "thepianist",
            fullName = "Oscar Delgadillo",
            password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
            token = "",
            role = Role.CANDIDATE
        ),
    )

}