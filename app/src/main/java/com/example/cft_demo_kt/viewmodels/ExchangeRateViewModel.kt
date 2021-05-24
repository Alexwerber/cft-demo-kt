package com.example.cft_demo_kt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cft_demo_kt.data.entities.ExchangeRate
import com.example.cft_demo_kt.data.remote.ApiService
import javax.inject.Inject

class ExchangeRateViewModel: ViewModel() {
    @Inject
    lateinit var apiService: ApiService

    private val exchangeRate: LiveData<List<ExchangeRate>> by lazy {
        MutableLiveData<List<ExchangeRate>>().also {
            loadExchangeRates()
        }
    }

    fun getExchangeRateList(): LiveData<List<ExchangeRate>> = exchangeRate

    private fun loadExchangeRates(): Unit {

    }
}