package com.example.tp5_kotlin.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp5_kotlin.ForecastModel.Forecast
import com.example.tp5_kotlin.RetrofitHelper
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class forecastViewModel:ViewModel() {

    private val _forecastData = MutableLiveData<Forecast>()
    val forecastData: LiveData<Forecast>
        get() = _forecastData

    fun fetchForecastData(city: String) {
        RetrofitHelper.RetrofitHelper.retrofitService.getForecast(city).enqueue(
            object : retrofit2.Callback<Forecast> {
                override fun onResponse(
                    call: retrofit2.Call<Forecast>,
                    response: retrofit2.Response<Forecast>
                ) {
                    if(response.isSuccessful) {
                        _forecastData.value = changeTimeFormat(response.body()!!)
                    }
                }
                override fun onFailure(call: retrofit2.Call<Forecast>, t: Throwable) {
                    Log.e("weatherViewModel", t.toString())
                }
            }
        )
    }
    private fun changeTimeFormat(forecast: Forecast): Forecast {
        val dateFormat = SimpleDateFormat("EEE, MMM d, yyyy", Locale.getDefault())
        val transformedList = forecast.list.map { day ->
            val transformedDate = dateFormat.format(Date(day.dt.toLong() * 1000))
            day.copy(dt = transformedDate)
        }
        return forecast.copy(list = transformedList)
    }

}


