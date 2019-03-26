package com.ayoprez.controlify.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData

@Database(entities = [SessionsData::class, Session::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sessionDataDao(): SessionDataDao
}