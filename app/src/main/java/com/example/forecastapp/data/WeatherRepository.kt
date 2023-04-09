package com.example.forecastapp.data

import com.example.forecastapp.network.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getHourlyForecast(lat:String,lon:String)= apiService.getHourlyForecast(lat=lat,lon=lon)
}