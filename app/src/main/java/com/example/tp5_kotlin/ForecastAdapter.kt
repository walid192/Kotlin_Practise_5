package com.example.tp5_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp5_kotlin.ForecastModel.Day

class ForecastAdapter(private val data: List<Day>): RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val textView:TextView=itemView.findViewById(R.id.tvDate)
        val temp:TextView=itemView.findViewById(R.id.temp)
        val humidity:TextView=itemView.findViewById(R.id.humidity)
        val pressure:TextView=itemView.findViewById(R.id.pressure)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.forecast_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.humidity.text=data[position].humidity.toString()
            holder.pressure.text=data[position].pressure.toString()
            holder.temp.text=data[position].temp.day.toString()
            holder.textView.text=data[position].dt

    }
}
