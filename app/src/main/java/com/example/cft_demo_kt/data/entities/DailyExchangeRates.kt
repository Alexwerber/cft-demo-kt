package com.example.cft_demo_kt.data.entities

import com.google.gson.annotations.SerializedName
import java.util.*

data class DailyExchangeRates(
    @SerializedName("date") var date: Date,
    @SerializedName("Timestamp") var timestamp: Date,
    @SerializedName("Valute") var valute: Map<String, ExchangeRate>
)
