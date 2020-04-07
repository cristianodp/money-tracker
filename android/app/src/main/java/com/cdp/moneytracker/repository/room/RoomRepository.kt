package com.cdp.moneytracker.repository.room

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.cdp.moneytracker.app.MoneyTrackerApplication

import com.cdp.moneytracker.repository.IRepository
import com.cdp.moneytracker.repository.model.Movement


class RoomRepository : IRepository {

    private var movementDao: MovementDao = MoneyTrackerApplication.database.movementDao()

    private val allMovements: LiveData<List<Movement>>

    init {
        allMovements = movementDao.getAll()
    }

    override fun save(movement: Movement) {
        SaveAsyncTask(movementDao).execute(movement)
    }

    override fun delete(vararg movement: Movement) {
        DeleteAsyncTask(movementDao).execute(*movement)
    }

    override fun getAllMovements(): LiveData<List<Movement>> = allMovements

    private class SaveAsyncTask internal constructor(private val dao: MovementDao) :
        AsyncTask<Movement, Void, Void>() {
        override fun doInBackground(vararg params: Movement): Void? {
            val movement = params[0]
            if (movement.id == 0L) {
                dao.insert(movement)
            } else {
                dao.update(movement)
            }
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: MovementDao) :
        AsyncTask<Movement, Void, Void>() {
        override fun doInBackground(vararg params: Movement): Void? {
            dao.delete(*params)
            return null
        }
    }
}