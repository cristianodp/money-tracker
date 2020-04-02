package com.cdp.moneytracker.repository

import androidx.lifecycle.LiveData
import com.cdp.moneytracker.repository.model.Movement

interface IRepository {

    fun save(movement: Movement)
    fun delete(vararg movement: Movement)
    fun getAllMovements(): LiveData<List<Movement>>

}