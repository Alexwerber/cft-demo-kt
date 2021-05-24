package com.example.cft_demo_kt.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cft_demo_kt.ExchangeRateApp
import com.example.cft_demo_kt.data.entities.DailyExchangeRates
import com.example.cft_demo_kt.data.entities.ExchangeRate
import com.example.cft_demo_kt.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ExchangeRateRepository {
    @Inject
    lateinit var apiService: ApiService

    private var data: MutableLiveData<List<ExchangeRate>>? = null

    init {
        ExchangeRateApp.appComponents.inject(this)
    }

    fun getFromNetwork(): Unit {
        apiService.getDailyExchangeRate().enqueue(object: Callback<DailyExchangeRates> {
            override fun onResponse(
                call: Call<DailyExchangeRates>,
                response: Response<DailyExchangeRates>
            ) {
                response.body()?.valute?.values?.toList()?.let { data?.value = it }
            }

            override fun onFailure(call: Call<DailyExchangeRates>, t: Throwable) {

            }
        })
    }

    fun getData(): LiveData<List<ExchangeRate>>? = data
}