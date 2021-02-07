package com.varivoda.igor.data.repository

import com.varivoda.igor.data.database.AppDatabase
import com.varivoda.igor.data.database.Points
import com.varivoda.igor.data.database.RiddleDao
import com.varivoda.igor.domain.model.PointsEntry
import com.varivoda.igor.domain.model.RiddleEntry
import com.varivoda.igor.domain.repository.RiddleRepository

class RiddleRepositoryImpl(private val database: AppDatabase) : RiddleRepository{

    override fun getAllRiddles(): List<RiddleEntry> {
        return database.riddleDao().getAllRiddles().map { it.toRiddleDTO() }
    }

    override fun resetPoints() {
        val points = database.riddleDao().getPoints()
        points.questionId = 0
        points.value = 0
        database.riddleDao().insertPoints(points)
    }

    override fun getPoints(): PointsEntry {
        return database.riddleDao().getPoints().toPointsEntry()
    }

    override fun insertPoints(pointsEntry: PointsEntry) {
        database.riddleDao().insertPoints(Points(pointsEntry.id, pointsEntry.questionId, pointsEntry.value))
    }

    override fun getQuestionId(): Int {
        return database.riddleDao().getQuestionId()
    }

    override fun getRiddlesForCategory(id: Int): List<RiddleEntry> {
        return database.riddleDao().getRiddlesForCategory(id).map { it.toRiddleDTO() }
    }

}