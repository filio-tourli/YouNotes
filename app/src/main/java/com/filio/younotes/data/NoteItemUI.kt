package com.filio.younotes.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.ZonedDateTime

@Parcelize
data class NoteItemUI(
    val id: Int,
    val title: String,
    val message: String,
    val createdAt: ZonedDateTime,
    val editedAt: ZonedDateTime,
) : Parcelable