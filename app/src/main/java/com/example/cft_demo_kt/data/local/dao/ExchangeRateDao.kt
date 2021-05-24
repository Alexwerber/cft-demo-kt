package com.example.cft_demo_kt.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cft_demo_kt.data.entities.ExchangeRate

@Dao
interface ExchangeRateDao {
    @Query("SELECT * FROM exchangeRate")
    fun getExchangeRate(): LiveData<List<ExchangeRate>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveExchangeRate(exchangeEntities: List<ExchangeRate>)
}