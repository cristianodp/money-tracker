package com.cdp.moneytracker.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cdp.moneytracker.repository.model.Movement
import com.cdp.moneytracker.repository.room.converters.DoubleConverter
import com.cdp.moneytracker.repository.room.converters.LocalDateConverter
import com.cdp.moneytracker.repository.room.converters.LocalDateTimeConverter
import com.cdp.moneytracker.repository.room.converters.MovementTypeConverter

@Database(entities = [(Movement::class)], version = 1)
@TypeConverters(
    LocalDateTimeConverter::class,
    LocalDateConverter::class,
    MovementTypeConverter::class,
    DoubleConverter::class
)
abstract class MoneyTrackerDatabase : RoomDatabase() {
    abstract fun movementDao(): MovementDao
}