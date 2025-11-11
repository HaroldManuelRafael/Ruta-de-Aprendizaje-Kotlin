package com.hrafael.roombasico.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hrafael.roombasico.data.entity.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {
    @Insert
    suspend fun insertar(persona: Persona)

    @Query("SELECT * FROM personas ORDER BY id DESC")
    fun obtenerPersonas(): Flow<List<Persona>>
}