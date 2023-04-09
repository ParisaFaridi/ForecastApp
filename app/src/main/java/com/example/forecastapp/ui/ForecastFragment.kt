package com.example.forecastapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.forecastapp.R
import com.example.forecastapp.adapter.DailyAdapter
import com.example.forecastapp.adapter.HourlyAdapter
import com.example.forecastapp.databinding.FragmentForecastBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.math.roundToInt


@AndroidEntryPoint
class ForecastFragment : Fragment() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var binding: FragmentForecastBinding
    lateinit var hourlyAdapter: HourlyAdapter
    lateinit var dailyAdapter: DailyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForecastBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHourlyForecast.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        hourlyAdapter = HourlyAdapter()

        binding.rvHourlyForecast.adapter = hourlyAdapter

        binding.rvDailyForecast.layoutManager =
            LinearLayoutManager(requireContext())
        dailyAdapter = DailyAdapter()

        binding.rvDailyForecast.adapter = dailyAdapter


        viewModel.getHourlyForecast("35.7219", "51.3347")
        viewModel.forecast.observe(viewLifecycleOwner) { response ->
            Glide.with(requireContext())
                .load(response.current?.weather?.get(0)?.icon?.let { getIcon(it) })
                .into(binding.ivIcon)
            binding.apply {
                tvMainTemp.text = response.current?.temp?.let { roundTemp(it) }
                tvMinMaxTemp.text =
                    "${response.daily?.get(0)?.temp?.min?.let { roundTemp(it) }}/${
                        response.daily?.get(0)?.temp?.max?.let {
                            roundTemp(it)
                        }
                    }"
                btnLocation.text = response.timezone?.split("/")?.get(1) ?: ""
                hourlyAdapter.submitList(response.hourly)
                dailyAdapter.submitList(response.daily)
            }
            binding.btnLocation.setOnClickListener {
                //findNavController().navigate(R.id.action_moviesFragment_to_mapsFragment)
            }
        }

        val t: Int = Date().getHours()
        if (t < 12) {
            binding.layout.setBackgroundDrawable(resources.getDrawable(R.drawable.morning_gradient));
        } else if (t >= 12 && t < 14) {
            binding.layout.setBackgroundDrawable(resources.getDrawable(R.drawable.noon_gradient));
        } else if (t >= 14 && t < 18) {
            binding.layout.setBackgroundDrawable(resources.getDrawable(R.drawable.evening_gradient));
        } else if (t >= 18 && t < 19) {
            binding.layout.setBackgroundDrawable(resources.getDrawable(R.drawable.dawn_gradient));
        } else {
            binding.layout.setBackgroundDrawable(resources.getDrawable(R.drawable.night_gradient));
        }
    }

    private fun roundTemp(double: Double): String {
        return double.roundToInt().toString() + "°"
    }

    private fun getIcon(code: String): Int {
        return when (code) {
            "01d"-> { R.drawable.clear_sky_morning}
            "02d"-> { R.drawable.few_cloud_morning}
            "03d"-> { R.drawable.scattered_clouds}
            "04d"-> { R.drawable.broken_cloud}
            "09d"-> { R.drawable.shower_raint}
            "10d"-> { R.drawable.rain}
            "11d"-> { R.drawable.thunderstorm}
            "13d"-> { R.drawable.snow}
            "50d"->{ R.drawable.mist}
            "01n"->{ R.drawable.clear_sky_night}
            "02n"-> { R.drawable.few_clound_night}
            "03n"-> { R.drawable.scattered_clouds}
            "04n"-> { R.drawable.broken_cloud}
            "09n"-> { R.drawable.shower_raint}
            "10n"-> { R.drawable.rain}
            "11n"-> { R.drawable.thunderstorm}
            "13n"-> { R.drawable.snow}
            else -> { R.drawable.mist}
        }
    }
}