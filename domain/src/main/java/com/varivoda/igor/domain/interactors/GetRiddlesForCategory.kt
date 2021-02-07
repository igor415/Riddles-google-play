package com.varivoda.igor.domain.interactors

import com.varivoda.igor.domain.model.RiddleEntry
import com.varivoda.igor.domain.repository.RiddleRepository

class GetRiddlesForCategory (private val riddleRepository: RiddleRepository){
    operator fun invoke(id: Int): List<RiddleEntry>{
        return riddleRepository.getRiddlesForCategory(id)
    }
}