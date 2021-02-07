package com.varivoda.igor.domain.interactors

import com.varivoda.igor.domain.repository.RiddleRepository

class SubtractFromScore (private val riddleRepository: RiddleRepository){

    operator fun invoke(){
        val points = riddleRepository.getPoints()
        points.value -= 50
        riddleRepository.insertPoints(points)
    }
}