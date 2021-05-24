package com.example.cft_demo_kt.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cft_demo_kt.ExchangeRateApp
import com.example.cft_demo_kt.R
import com.example.cft_demo_kt.data.entities.DailyExchangeRates
import com.example.cft_demo_kt.data.remote.ApiService
import com.example.cft_demo_kt.ui.adapters.ExchangeRateAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var apiService: ApiService

    val adapter = ExchangeRateAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as ExchangeRateApp).appComponents.inject(this)

        val recycler: RecyclerView = findViewById(R.id.recycle_view)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        getFromNetwork()
    }

    private fun getFromNetwork(): Unit {
        apiService.getDailyExchangeRate().enqueue(object: Callback<DailyExchangeRates> {
            override fun onResponse(
                call: Call<DailyExchangeRates>,
                response: Response<DailyExchangeRates>
            ) {
                response.body()?.valute?.values?.toList()?.let { adapter.setData(it) }
            }

            override fun onFailure(call: Call<DailyExchangeRates>, t: Throwable) {

            }
        })
    }
}