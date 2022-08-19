package com.filio.younotes.db

import androidx.room.TypeConverter
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * We use this class to manually add room-support for these data types
 * */
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