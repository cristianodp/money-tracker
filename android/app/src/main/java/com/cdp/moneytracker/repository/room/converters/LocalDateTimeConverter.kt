package com.cdp.moneytracker.repository.room.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime


class LocalDateTimeConverter {
    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime?): String? = value.toString()

    @TypeConverter
    fun toLocalDateTime(value: String?): LocalDateTime? = LocalDateTime.parse(value)
}
