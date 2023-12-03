package com.example.tp5_kotlin.ForecastModel

data class Forecast(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Day>,
    val message: Double
)