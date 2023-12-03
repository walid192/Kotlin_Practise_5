package com.example.tp5_kotlin.Model

data class Forecast(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<>,
    val message: Double
)