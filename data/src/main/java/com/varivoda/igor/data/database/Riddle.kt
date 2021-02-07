package com.varivoda.igor.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.varivoda.igor.domain.model.RiddleEntry

@Entity
data class Riddle(
    @PrimaryKey
    val id: Int,
    val question: String,
    val answer: String,
    val categoryId: Int
){
    fun toRiddleDTO(): RiddleEntry{
        return RiddleEntry(id, question, answer, categoryId)
    }
}