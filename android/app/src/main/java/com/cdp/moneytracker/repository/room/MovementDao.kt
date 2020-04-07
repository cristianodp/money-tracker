package com.cdp.moneytracker.repository.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cdp.moneytracker.repository.model.Movement
import java.sql.RowId

@Dao
interface MovementDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movement: Movement): Long

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun update(movement: Movement)

    @Delete
    fun delete(vararg movement: Movement)

    @Query("SELECT * FROM movement_table ORDER BY date DESC")
    fun getAll(): LiveData<List<Movement>>

    @Query("SELECT * FROM movement_table WHERE id = :id")
    fun getById(id:Long): LiveData<Movement>

    @Query("SELECT * FROM movement_table WHERE description = :description ORDER BY date DESC")
    fun getByDescription(description: String): LiveData<List<Movement>>
}