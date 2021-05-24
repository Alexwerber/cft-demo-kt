package com.example.cft_demo_kt.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.cft_demo_kt.ExchangeRateApp
import com.example.cft_demo_kt.data.entities.DailyExchangeRates
import com.example.cft_demo_kt.data.entities.ExchangeRate
import com.example.cft_demo_kt.data.local.dao.ExchangeRateDao
import com.example.cft_demo_kt.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors
import javax.inject.Inject

class ExchangeRateRepository {
    @Inject
    lateinit var apiService: ApiService
    @Inject
    lateinit var exchangeRateDao: ExchangeRateDao

    private var data: MediatorLiveData<List<ExchangeRate>> = MediatorLiveData()

    init {
        ExchangeRateApp.appComponents.inject(this)
        getFromNetwork()
    }

    fun getFromNetwork(): Unit {
        apiService.getDailyExchangeRate().enqueue(object: Callback<DailyExchangeRates> {
            override fun onResponse(
                call: Call<DailyExchangeRates>,
                response: Response<DailyExchangeRates>
            ) {
                if(response.isSuccessful) {
                    response.body()?.valute?.values?.toList()?.let {
                        saveToDatabase(it)
                    }
                }
            }

            override fun onFailure(call: Call<DailyExchangeRates>, t: Throwable) {

            }
        })
    }

    fun loadData() {
        var dbResource = getDataFromDb()

        data.addSource(dbResource) {
            data.value = it
        }
    }

    private fun getDataFromDb() = exchangeRateDao.getExchangeRate()

    private fun saveToDatabase(data: List<ExchangeRate>) {
        Executors.newSingleThreadExecutor().execute(
            fun () {exchangeRateDao.saveExchangeRate(data)}
        )
    }

    fun getData(): MutableLiveData<List<ExchangeRate>> = data
}