package com.example.cft_demo_kt.data.remote

import com.example.cft_demo_kt.data.entities.DailyExchangeRates
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/daily_json.js")
    fun getDailyExchangeRate(): Call<DailyExchangeRates>
}