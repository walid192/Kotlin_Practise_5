package com.example.tp5_kotlin

import com.example.tp5_kotlin.ForecastModel.Forecast
import com.example.tp5_kotlin.Model.weatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("weather?APPID=2fc3eff97377367b2b1750842ec11a9f&units=metric")
    fun getWeather(@Query("q") city: String): Call<weatherModel>

    @GET("forecast/daily?APPID=17db59488cadcad345211c36304a9266")
    fun getForecast(@Query("q") city: String): Call<Forecast>
}
