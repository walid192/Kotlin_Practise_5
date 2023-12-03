package com.example.tp5_kotlin.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp5_kotlin.Model.weatherModel
import com.example.tp5_kotlin.RetrofitHelper

class weatherViewModel() : ViewModel() {
    private val _weatherData = MutableLiveData<weatherModel>()
    val weatherData: LiveData<weatherModel>
        get() = _weatherData

    fun fetchWeatherData(city: String) {
       RetrofitHelper.RetrofitHelper.retrofitService.getWeather(city).enqueue(
            object : retrofit2.Callback<weatherModel> {
                override fun onResponse(
                    call: retrofit2.Call<weatherModel>,
                    response: retrofit2.Response<weatherModel>
                ) {
                    if(response.isSuccessful) {
                        _weatherData.value = response.body()
                        }
                }
                override fun onFailure(call: retrofit2.Call<weatherModel>, t: Throwable) {
                    Log.e("weatherViewModel", t.toString())
                }
            }
        )
    }


}