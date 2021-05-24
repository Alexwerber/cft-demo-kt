package com.example.cft_demo_kt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cft_demo_kt.data.entities.ExchangeRate
import com.example.cft_demo_kt.data.local.dao.ExchangeRateDao

@Database(entities = arrayOf(ExchangeRate::class), version = 1)
abstract class ExchangeRateDatabase: RoomDatabase() {
    abstract fun getExchangeRateDao(): ExchangeRateDao
}