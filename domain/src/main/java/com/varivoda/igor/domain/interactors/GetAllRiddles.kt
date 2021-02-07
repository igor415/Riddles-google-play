package com.varivoda.igor.domain.interactors

import com.varivoda.igor.domain.model.RiddleEntry
import com.varivoda.igor.domain.repository.RiddleRepository

class GetAllRiddles (private val riddleRepository: RiddleRepository){

    operator fun invoke(): List<RiddleEntry> = riddleRepository.getAllRiddles()
}