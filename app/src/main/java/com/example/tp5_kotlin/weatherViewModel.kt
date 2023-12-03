package com.example.tp5_kotlin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.WeatherResponse

class weatherViewModel() : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse>
        get() = _weatherData

    fun fetchWeatherData(city: String) {
       RetrofitHelper.RetrofitHelper.retrofitService.getWeather(city).enqueue(
            object : retrofit2.Callback<WeatherResponse> {
                override fun onResponse(
                    call: retrofit2.Call<WeatherResponse>,
                    response: retrofit2.Response<WeatherResponse>
                ) {
                    if(response.isSuccessful) {
                        _weatherData.value = response.body()
                    }
                }
                override fun onFailure(call: retrofit2.Call<WeatherResponse>, t: Throwable) {
                    Log.e("weatherViewModel", t.toString())
                }
            }
        )
    }


}