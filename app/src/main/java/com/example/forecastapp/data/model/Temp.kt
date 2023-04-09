package com.example.forecastapp.data.model

import com.squareup.moshi.Json

data class Temp(

	@Json(name="min")
	val min: Double? = null,

	@Json(name="max")
	val max: Double? = null,

	@Json(name="eve")
	val eve: Any? = null,

	@Json(name="night")
	val night: Any? = null,

	@Json(name="day")
	val day: Any? = null,

	@Json(name="morn")
	val morn: Any? = null
)