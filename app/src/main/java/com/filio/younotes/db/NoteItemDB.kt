package com.filio.younotes.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "notes-table")
data class NoteItemDB(
    val title: String,

    val message: String,

    val createdAt: ZonedDateTime,

    val editedAt: ZonedDateTime,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)