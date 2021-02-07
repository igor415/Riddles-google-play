package com.varivoda.igor.domain.interactors

import com.varivoda.igor.domain.repository.RiddleRepository

class GetQuestionId (private val riddleRepository: RiddleRepository){

    operator fun invoke(): Int{
        return riddleRepository.getQuestionId()
    }
}