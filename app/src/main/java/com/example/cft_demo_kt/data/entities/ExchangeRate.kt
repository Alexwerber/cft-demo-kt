package com.example.cft_demo_kt.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ExchangeRate(
    @PrimaryKey
    @SerializedName("CharCode") var ticker: String,
    @SerializedName("Nominal") var nominal: Int,
    @SerializedName("Name") var name: String,
    @SerializedName("Value") var value: Double,
    @SerializedName("Previous") var previousValue: Double
)
