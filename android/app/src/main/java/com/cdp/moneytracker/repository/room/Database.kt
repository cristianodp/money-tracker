package com.cdp.moneytracker.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cdp.moneytracker.repository.model.Movement
import com.cdp.moneytracker.repository.room.converters.LocalDateTimeConverter
import com.cdp.moneytracker.repository.room.converters.MovementTypeConverter
import com.cdp.moneytracker.repository.room.converters.DoubleConverter

@Database(entities = [(Movement::class)], version = 1)
@TypeConverters(LocalDateTimeConverter::class, MovementTypeConverter::class, DoubleConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun movementDao(): MovementDao
}