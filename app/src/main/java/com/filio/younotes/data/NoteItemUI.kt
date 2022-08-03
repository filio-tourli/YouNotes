package com.filio.younotes.data

import java.time.ZonedDateTime

data class NoteItemUI(
    val id: Int,
    val title: String,
    val message: String,
    val createdAt: ZonedDateTime,
    val editedAt: ZonedDateTime,
)