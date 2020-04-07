package com.cdp.moneytracker.repository.model

import androidx.annotation.FloatRange
import androidx.annotation.NonNull
import androidx.annotation.Size
import androidx.room.Entity
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "movement_table")
data class Movement(

    @NonNull
    @Size(min = 3, max = 100)
    var description: String,

    @NonNull
    @FloatRange(from=0.01)
    var price: Double,

    @NonNull
    var type: MovementType = MovementType.IN,

    @NonNull
    var date: LocalDate = LocalDate.now()

) : BaseEntity()