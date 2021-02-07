package com.varivoda.igor.domain.repository

import com.varivoda.igor.domain.model.PointsEntry
import com.varivoda.igor.domain.model.RiddleEntry

interface RiddleRepository {

    fun getAllRiddles(): List<RiddleEntry>

    fun resetPoints()

    fun getPoints(): PointsEntry

    fun insertPoints(pointsEntry: PointsEntry)

    fun getQuestionId(): Int

    fun getRiddlesForCategory(id: Int): List<RiddleEntry>
}