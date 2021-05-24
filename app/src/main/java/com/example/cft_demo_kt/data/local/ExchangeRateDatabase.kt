package com.example.cft_demo_kt.data.local

import androidx.room.Database
import com.example.cft_demo_kt.data.entities.ExchangeRate

@Database(entities = arrayOf(ExchangeRate::class), version = 1)
abstract class ExchangeRateDatabase {
    abstract fun getExchangeRateDatabase()
}