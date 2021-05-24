package com.example.cft_demo_kt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cft_demo_kt.data.ExchangeRateRepository
import com.example.cft_demo_kt.data.entities.ExchangeRate

class ExchangeRateViewModel: ViewModel() {
    private val exchangeRateRepository = ExchangeRateRepository()
    private var exchangeRateList: MutableLiveData<List<ExchangeRate>> = MutableLiveData()

    init {
        exchangeRateList = exchangeRateRepository.getData()
        loadData()
    }

    fun getExchangeRateList(): LiveData<List<ExchangeRate>> = exchangeRateList

    private fun loadExchangeRates(): Unit {
        exchangeRateRepository.getFromNetwork()
    }

    private fun loadData() {
        exchangeRateRepository.loadData()
    }
}