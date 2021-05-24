package com.example.cft_demo_kt.dependencies.modules

import android.app.Application
import androidx.room.Room
import com.example.cft_demo_kt.data.local.ExchangeRateDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideExchangeRateDatabase(application: Application) =
        Room.databaseBuilder(application, ExchangeRateDatabase::class.java, "exchangeRate.db").build()

    @Provides
    @Singleton
    fun provideExchangeRateDao(exchangeRateDatabase: ExchangeRateDatabase) =
        exchangeRateDatabase.getExchangeRateDao()
}