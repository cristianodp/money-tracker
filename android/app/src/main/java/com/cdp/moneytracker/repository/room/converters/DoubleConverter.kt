package com.cdp.moneytracker.repository.room.converters

import androidx.room.TypeConverter

class DoubleConverter {
    @TypeConverter
    fun fromDouble(value: Number): String = value.toString()

    @TypeConverter
    fun toDouble(value: String): Double? = value.toDouble()
}