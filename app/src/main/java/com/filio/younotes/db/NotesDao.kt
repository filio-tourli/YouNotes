package com.filio.younotes.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert
    suspend fun insert(NotesItemDB: NoteItemDB)

    @Update
    suspend fun update(NotesItemDB: NoteItemDB)

    @Delete
    suspend fun delete(NotesItemDB: NoteItemDB)

    @Query("SELECT * FROM 'notes-table'")
    fun fetchAllNotes(): Flow<List<NoteItemDB>>
}