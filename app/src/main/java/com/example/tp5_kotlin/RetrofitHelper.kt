package com.example.tp5_kotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    object RetrofitHelper {

        private const val baseUrl = "https://api.openweathermap.org/data/2.5/"
        private val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService: WeatherAPI by lazy { retrofit.create(WeatherAPI::class.java) }
    }
}