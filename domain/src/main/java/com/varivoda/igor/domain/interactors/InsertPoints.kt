package com.varivoda.igor.domain.interactors

import com.varivoda.igor.domain.repository.RiddleRepository

class InsertPoints (private val riddleRepository: RiddleRepository){

    operator fun invoke(questionId: Int, add: Int){
        val points = riddleRepository.getPoints()
        if(questionId > points.questionId){
            points.questionId = questionId
            points.value += add
            riddleRepository.insertPoints(points)
        }

    }
}