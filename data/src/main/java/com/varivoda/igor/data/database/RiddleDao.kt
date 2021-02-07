package com.varivoda.igor.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RiddleDao {

    @Query("SELECT * FROM Riddle")
    fun getAllRiddles(): List<Riddle>

    @Query("SELECT * FROM Points where id = 1")
    fun getPoints(): Points

    @Query("SELECT questionId FROM Points where id = 1")
    fun getQuestionId(): Int


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPoints(points: Points)

    @Query("SELECT * FROM Riddle where categoryId = :id")
    fun getRiddlesForCategory(id: Int): List<Riddle>


}