package com.example.tp5_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.tp5_kotlin.databinding.ActivityMainBinding
import com.example.tp5_kotlin.viewModels.weatherViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var spinner: Spinner
    private var weatherViewModel: weatherViewModel = weatherViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weatherViewModel.weatherData.observe(
            this
        ) {
            if(it != null) {
                binding.humidity.text = "Humidity : ${it.main?.humidity.toString()}"
                binding.pressure.text = "Pressure : ${it.main?.pressure.toString()}"
                binding.temperature.text= it.main?.temp.toString()
                binding.forecast.text=it.weather?.get(0)?.description.toString()
            }
        }
        val cities = listOf<String>(
            "London",
            "Tunis",
            "Paris",
            "New York",
            "Berlin",
            "Tokyo",
            "Moscow",
            "Madrid",
            "Rome",
            "Cairo"
        )

        spinner = binding.spinner
        val adapter = ArrayAdapter(
            this,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item, cities
        )
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?, position: Int, id: Long
            ) {
                weatherViewModel.fetchWeatherData(cities[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


        binding.button.setOnClickListener {
           intent= Intent(this,ForecastActivity::class.java)
            intent.putExtra("city",spinner.selectedItem.toString())
            startActivity(intent)
        }
    }
}