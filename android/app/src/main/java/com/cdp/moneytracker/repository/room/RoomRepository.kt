package com.cdp.moneytracker.repository.room

import androidx.lifecycle.LiveData
import com.cdp.moneytracker.repository.IRepository
import com.cdp.moneytracker.repository.model.Movement
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomRepository(
    @Inject
    val movementDao: MovementDao
) : IRepository {

    override fun save(movement: Movement) {
        if (movement.id == 0L) {
            movementDao.insert(movement)
        } else {
            movementDao.update(movement)
        }
    }

    override fun delete(vararg movement: Movement) {
        movementDao.delete(*movement)
    }

    override fun getAllMovements(): LiveData<List<Movement>> {
        return movementDao.getAll()
    }

}