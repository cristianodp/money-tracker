package com.cdp.moneytracker.repository.room.converters

import androidx.room.TypeConverter
import com.cdp.moneytracker.repository.model.MovementType

class MovementTypeConverter {
    @TypeConverter
    fun fromMovementType(value: MovementType): String =  value.name

    @TypeConverter
    fun toMovementType(value: String): MovementType? = MovementType.valueOf(value)

}