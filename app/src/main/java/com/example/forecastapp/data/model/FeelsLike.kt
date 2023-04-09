package com.example.forecastapp.data.model

import com.squareup.moshi.Json

data class FeelsLike(

	@Json(name="eve")
	val eve: Any? = null,

	@Json(name="night")
	val night: Any? = null,

	@Json(name="day")
	val day: Any? = null,

	@Json(name="morn")
	val morn: Any? = null
)