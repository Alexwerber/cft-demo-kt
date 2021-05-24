package com.example.cft_demo_kt.data.entities

import com.google.gson.annotations.SerializedName

data class ExchangeRate(
    @SerializedName("CharCode") var ticker: String,
    @SerializedName("Nominal") var nominal: Int,
    @SerializedName("Name") var name: String,
    @SerializedName("Value") var value: Double,
    @SerializedName("Previous") var previousValue: Double
)
