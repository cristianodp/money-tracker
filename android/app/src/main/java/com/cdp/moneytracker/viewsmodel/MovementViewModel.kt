package com.cdp.moneytracker.viewsmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.cdp.moneytracker.repository.model.Movement
import com.cdp.moneytracker.repository.model.MovementType
import com.cdp.moneytracker.repository.room.RoomRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class MovementViewModel(private val repository: RoomRepository = RoomRepository()) : ViewModel() {

    var isMovementTypeIN = ObservableField<Boolean>(false)
    var isMovementTypeOUT = ObservableField<Boolean>(true)
    var date = ObservableField<String>(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE))
    var description = ObservableField<String>("")
    var price = ObservableField<String>("");


    fun save() {
        val mov = Movement(
            description = description.get() ?: "",
            date = LocalDate.now(),// date,
            price = (price.get() ?: "0.0").toDouble(),
            type = if (isMovementTypeIN.get()!!) MovementType.IN else MovementType.OUT
        )
        repository.save(mov)
    }

}