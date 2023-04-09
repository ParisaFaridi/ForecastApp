package com.example.forecastapp.data.model

import com.squareup.moshi.Json

data class Forecast(

    @Json(name="current")
	val current: Current? = null,

    @Json(name="timezone")
	val timezone: String? = null,

    @Json(name="timezone_offset")
	val timezoneOffset: String? = null,

    @Json(name="daily")
	val daily: List<DailyItem?>? = null,

    @Json(name="lon")
	val lon: Any? = null,

    @Json(name="hourly")
	val hourly: List<HourlyItem?>? = null,

    @Json(name="lat")
	val lat: Any? = null
)