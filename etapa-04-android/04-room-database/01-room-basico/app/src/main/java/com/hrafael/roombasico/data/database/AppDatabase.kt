package com.hrafael.roombasico.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hrafael.roombasico.data.dao.PersonaDao
import com.hrafael.roombasico.data.entity.Persona

@Database(entities = [Persona::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personaDao(): PersonaDao
}