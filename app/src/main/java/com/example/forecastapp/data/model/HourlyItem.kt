package com.example.forecastapp.data.model

import com.squareup.moshi.Json

data class HourlyItem(

	@Json(name="rain")
	val rain: Rain? = null,

	@Json(name="temp")
	val temp: Any? = null,

	@Json(name="visibility")
	val visibility: String? = null,

	@Json(name="uvi")
	val uvi: String? = null,

	@Json(name="pressure")
	val pressure: String? = null,

	@Json(name="clouds")
	val clouds: String? = null,

	@Json(name="feels_like")
	val feelsLike: Any? = null,

	@Json(name="wind_gust")
	val windGust: Any? = null,

	@Json(name="dt")
	val dt: String? = null,

	@Json(name="pop")
	val pop: String? = null,

	@Json(name="wind_deg")
	val windDeg: Int? = null,

	@Json(name="dew_point")
	val dewPoint: Any? = null,

	@Json(name="weather")
	val weather: List<WeatherItem?>? = null,

	@Json(name="humidity")
	val humidity: String? = null,

	@Json(name="wind_speed")
	val windSpeed: Any? = null
)