package com.filio.younotes.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [NoteItemDB::class], version = 1)
@TypeConverters(Converters::class)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun getNotesDao(): NotesDao
}