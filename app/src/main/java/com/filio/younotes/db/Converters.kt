package com.filio.younotes.db

import androidx.room.TypeConverter
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

object Converters {

    @TypeConverter
    fun zoneDateTimeToLong(date: Long): ZonedDateTime {
        val instant = Instant.ofEpochSecond(date)
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())
    }

    @TypeConverter
    fun longToZoneDateTime(date: ZonedDateTime): Long {
        return date.toEpochSecond()
    }
}