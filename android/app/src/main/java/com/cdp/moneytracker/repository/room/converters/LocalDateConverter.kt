package com.cdp.moneytracker.repository.room.converters

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime


class LocalDateConverter {
    @TypeConverter
    fun fromLocalDate(value: LocalDate?): String? = value.toString()

    @TypeConverter
    fun toLocalDate(value: String?): LocalDate? = LocalDate.parse(value)
}
