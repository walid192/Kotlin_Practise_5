package com.example.tp5_kotlin.ForecastModel

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)