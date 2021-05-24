package com.example.cft_demo_kt.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cft_demo_kt.R
import com.example.cft_demo_kt.data.entities.ExchangeRate
import com.example.cft_demo_kt.ui.adapters.ExchangeRateAdapter
import com.example.cft_demo_kt.viewmodels.ExchangeRateViewModel

class MainActivity : AppCompatActivity() {
    private val adapter = ExchangeRateAdapter()
    lateinit var data: LiveData<List<ExchangeRate>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = ViewModelProvider(this).get(ExchangeRateViewModel::class.java)

        val recycler: RecyclerView =  findViewById<RecyclerView>(R.id.recycle_view).apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        model.getExchangeRateList()?.observe(this, {
            adapter.setData(it)
        })
    }
}