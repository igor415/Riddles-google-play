package com.varivoda.igor.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.varivoda.igor.domain.model.PointsEntry

@Entity
data class Points(
    @PrimaryKey
    val id: Int,
    var questionId: Int,
    var value: Int
){
    fun toPointsEntry(): PointsEntry{
        return  PointsEntry(id,questionId, value)
    }
}