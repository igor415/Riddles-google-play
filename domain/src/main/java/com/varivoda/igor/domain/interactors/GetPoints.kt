package com.varivoda.igor.domain.interactors

import com.varivoda.igor.domain.model.PointsEntry
import com.varivoda.igor.domain.repository.RiddleRepository

class GetPoints (private val riddleRepository: RiddleRepository){

    operator fun invoke(): PointsEntry = riddleRepository.getPoints()
}