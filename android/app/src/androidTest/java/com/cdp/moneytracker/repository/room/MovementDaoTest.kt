package com.cdp.moneytracker.repository.room

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cdp.moneytracker.app.blockingObserve
import com.cdp.moneytracker.repository.model.Movement
import com.cdp.moneytracker.repository.model.MovementType
import org.junit.*
import org.junit.runner.RunWith
import java.time.LocalDateTime


@RunWith(AndroidJUnit4::class)
open class MovementDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: Database

    @Before
    fun initDb() {
        // using an in-memory database because the information stored here disappears after test
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            Database::class.java
        )
            // allowing main thread queries, just for testing
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun should_return_no_movements() {
        val expected = 0
        val actual = database.movementDao().getAll().value?.size ?: 0
        Assert.assertEquals(expected, actual)

    }

    @Test
    fun should_insert_movement() {
        val expected = Movement(
            description = "Test",
            type = MovementType.IN,
            datetime = LocalDateTime.now(),
            price = 1.0
        )
        val rowId = database.movementDao().insert(expected)
        val actual = database.movementDao().getById(rowId).blockingObserve()
        Assert.assertEquals(expected, actual)

    }

    @Test
    fun should_return_movements() {

        database.movementDao().insert(Movement(
            description = "Test",
            type = MovementType.IN,
            datetime = LocalDateTime.now(),
            price = 1.0
        ))

        database.movementDao().insert(Movement(
            description = "Test2",
            type = MovementType.IN,
            datetime = LocalDateTime.now(),
            price = 1.0
        ))

        val expected = 2
        val actual = database.movementDao().getAll().blockingObserve()?.size ?: 0
        Assert.assertEquals(expected, actual)

    }

    @Test
    fun should_delete_movements() {

        database.movementDao().insert(Movement(
            description = "Test",
            type = MovementType.IN,
            datetime = LocalDateTime.now(),
            price = 1.0
        ))

        val rowId = database.movementDao().insert(Movement(
            description = "Test2",
            type = MovementType.IN,
            datetime = LocalDateTime.now(),
            price = 1.0
        ))

        val mov2 = database.movementDao().getById(rowId).blockingObserve()!!

        database.movementDao().delete(mov2)

        val expected = 1
        val actual = database.movementDao().getAll().blockingObserve()?.size ?: 0
        Assert.assertEquals(expected, actual)

    }

}