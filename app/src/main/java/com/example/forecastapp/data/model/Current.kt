package com.example.forecastapp.data.model

import com.squareup.moshi.Json

data class Current(

	@Json(name="rain")
	val rain: Rain? = null,

	@Json(name="sunrise")
	val sunrise: Int? = null,

	@Json(name="temp")
	val temp: Double? = null,

	@Json(name="visibility")
	val visibility: Int? = null,

	@Json(name="uvi")
	val uvi: String? = null,

	@Json(name="pressure")
	val pressure: String? = null,

	@Json(name="clouds")
	val clouds: String? = null,

	@Json(name="feels_like")
	val feelsLike: String? = null,

	@Json(name="dt")
	val dt: String? = null,

	@Json(name="wind_deg")
	val windDeg: String? = null,

	@Json(name="dew_point")
	val dewPoint: String? = null,

	@Json(name="sunset")
	val sunset: String? = null,

	@Json(name="weather")
	val weather: List<WeatherItem?>? = null,

	@Json(name="humidity")
	val humidity: String? = null,

	@Json(name="wind_speed")
	val windSpeed: Any? = null
)