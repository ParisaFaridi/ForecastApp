package com.example.forecastapp.network

import com.example.forecastapp.data.model.Forecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


const val KEY = "cabdbda40038ba7d1165b953b1c7bd6c"

interface ApiService {

    @GET("onecall?&exclude=minutely,alerts")
    suspend fun getHourlyForecast(
        @Query("lat")
        lat:String,
        @Query("lon")
        lon:String,
        @Query("appid")
        consumerKey: String = KEY,
        @Query("units")
        units:String="metric",
    ): Response<Forecast>

}

