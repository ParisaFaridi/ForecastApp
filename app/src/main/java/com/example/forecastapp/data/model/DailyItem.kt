package com.example.forecastapp.data.model

import com.squareup.moshi.Json

data class DailyItem(

	@Json(name="moonset")
	val moonset: String? = null,

	@Json(name="sunrise")
	val sunrise: String? = null,

	@Json(name="temp")
	val temp: Temp? = null,

	@Json(name="moon_phase")
	val moonPhase: Any? = null,

	@Json(name="uvi")
	val uvi: Any? = null,

	@Json(name="moonrise")
	val moonrise: String? = null,

	@Json(name="pressure")
	val pressure: String? = null,

	@Json(name="clouds")
	val clouds: String? = null,

	@Json(name="feels_like")
	val feelsLike: FeelsLike? = null,

	@Json(name="wind_gust")
	val windGust: Any? = null,

	@Json(name="dt")
	val dt: String? = null,

	@Json(name="pop")
	val pop: Any? = null,

	@Json(name="wind_deg")
	val windDeg: String? = null,

	@Json(name="dew_point")
	val dewPoint: Any? = null,

	@Json(name="sunset")
	val sunset: String? = null,

	@Json(name="weather")
	val weather: List<WeatherItem?>? = null,

	@Json(name="humidity")
	val humidity: String? = null,

	@Json(name="wind_speed")
	val windSpeed: Any? = null,

	@Json(name="rain")
	val rain: Any? = null
)