package com.filio.younotes.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert
    suspend fun insert(notesItemDB: NoteItemDB)

    @Update
    suspend fun update(notesItemDB: NoteItemDB)

    @Delete
    suspend fun delete(notesItemDB: NoteItemDB)

    @Query("SELECT * FROM 'notes-table'")
    fun fetchAllNotes(): Flow<List<NoteItemDB>>
}