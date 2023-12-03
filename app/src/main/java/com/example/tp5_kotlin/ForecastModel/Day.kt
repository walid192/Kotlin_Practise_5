package com.example.tp5_kotlin.ForecastModel

data class Day(
    val clouds: Int,
    val deg: Int,
    var dt: String,
    val feels_like: FeelsLike,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    var sunrise: Int,
    var sunset: Int,
    val temp: Temp,
    val weather: List<Weather>
)