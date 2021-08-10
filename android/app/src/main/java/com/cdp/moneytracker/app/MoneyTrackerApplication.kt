package com.cdp.moneytracker.app

import android.app.Application
import androidx.room.Room
import com.cdp.moneytracker.repository.room.MoneyTrackerDatabase

class MoneyTrackerApplication: Application() {
    companion object {
        lateinit var database: MoneyTrackerDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this,
            MoneyTrackerDatabase::class.java,
            "money_tracker_database")
            .build()
    }
}