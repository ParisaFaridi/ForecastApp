package com.example.forecastapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecastapp.data.WeatherRepository
import com.example.forecastapp.data.model.Forecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    val forecast = MutableLiveData<Forecast>()

    fun getHourlyForecast(lat: String,lon:String) = viewModelScope.launch {
        viewModelScope.launch {
            forecast.postValue(repository.getHourlyForecast(lat=lat,lon=lon).body())
        }
    }
}