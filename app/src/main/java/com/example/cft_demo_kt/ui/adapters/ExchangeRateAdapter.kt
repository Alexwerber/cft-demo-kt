package com.example.cft_demo_kt.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cft_demo_kt.R
import com.example.cft_demo_kt.data.entities.ExchangeRate
import java.util.*

class ExchangeRateAdapter: RecyclerView.Adapter<ExchangeRateAdapter.ViewHolder>() {

    private var exchangeRateList: List<ExchangeRate> = emptyList()

    fun setData(list: List<ExchangeRate>) {
        this.exchangeRateList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_exchange_rate_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exchangeRate = exchangeRateList[position]
        val formatter = getExchangeRateFormatter(exchangeRate)

        holder.currencyName.text = exchangeRate.name
        holder.currencyRate.text = formatter.toString()
    }

    override fun getItemCount(): Int =
        exchangeRateList.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val currencyName: TextView = itemView.findViewById(R.id.currency_name)
        val currencyRate: TextView = itemView.findViewById(R.id.currency_rate)
        val currencyPercent: TextView = itemView.findViewById(R.id.currency_percent)
        val currencyFlag: ImageView = itemView.findViewById(R.id.currency_flag)
        val currencyPercentArrow: ImageView = itemView.findViewById(R.id.currency_percent_arrow)
    }

    private fun getExchangeRateFormatter(exchangeRate: ExchangeRate): Formatter =
        Formatter()
            .format("%.2f ₽ / %d %s",
                exchangeRate.value,
                exchangeRate.nominal,
                exchangeRate.ticker)
}