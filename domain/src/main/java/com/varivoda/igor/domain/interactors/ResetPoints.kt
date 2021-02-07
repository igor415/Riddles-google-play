package com.varivoda.igor.domain.interactors

import com.varivoda.igor.domain.repository.RiddleRepository

class ResetPoints (private val riddleRepository: RiddleRepository){

    operator fun invoke(){
        riddleRepository.resetPoints()
    }
}