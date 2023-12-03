package com.example.tp5_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp5_kotlin.databinding.ActivityForecastBinding
import com.example.tp5_kotlin.viewModels.forecastViewModel

class ForecastActivity : AppCompatActivity() {
    lateinit var binding: ActivityForecastBinding
    private var forecastViewModel: forecastViewModel = forecastViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForecastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView

        val city = intent.getStringExtra("city")

        forecastViewModel.forecastData.observe(
            this
        ) {
            if (it != null) {
                Log.d("ForecastActivity", "Data updated: $it")
                recyclerView.adapter = ForecastAdapter(it.list)
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        }
        forecastViewModel.fetchForecastData(city.toString())
    }

}