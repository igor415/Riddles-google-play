package com.varivoda.igor.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Riddle::class, Points::class] ,version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun riddleDao(): RiddleDao
}