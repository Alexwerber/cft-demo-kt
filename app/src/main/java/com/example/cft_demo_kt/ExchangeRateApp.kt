package com.example.cft_demo_kt

import android.app.Application
import com.example.cft_demo_kt.dependencies.components.AppComponents
import com.example.cft_demo_kt.dependencies.components.DaggerAppComponents

class ExchangeRateApp: Application() {
    lateinit var appComponents: AppComponents

    override fun onCreate() {
        super.onCreate()

        appComponents = DaggerAppComponents.builder().application(this)?.build()!!
    }
}