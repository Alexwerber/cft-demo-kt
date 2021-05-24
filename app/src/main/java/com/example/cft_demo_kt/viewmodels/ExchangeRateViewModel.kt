package com.example.cft_demo_kt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cft_demo_kt.data.ExchangeRateRepository
import com.example.cft_demo_kt.data.entities.ExchangeRate

class ExchangeRateViewModel: ViewModel() {
    private val exchangeRateRepository = ExchangeRateRepository()
    private var exchangeRateList: LiveData<List<ExchangeRate>>? = exchangeRateRepository.getData()

    fun getExchangeRateList(): LiveData<List<ExchangeRate>>? = exchangeRateList

    private fun loadExchangeRates(): Unit {
        exchangeRateRepository.getFromNetwork()
    }
}