package com.example.forecastapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.forecastapp.R
import com.example.forecastapp.databinding.DailyItemBinding
import com.example.forecastapp.data.model.DailyItem

class DailyAdapter : ListAdapter<DailyItem, DailyAdapter.ItemHolder>(FormulaDiffCallBack) {

    object FormulaDiffCallBack : DiffUtil.ItemCallback<DailyItem>() {
        override fun areItemsTheSame(oldItem: DailyItem, newItem: DailyItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DailyItem, newItem: DailyItem): Boolean {
            return oldItem.windDeg == newItem.windDeg
        }
    }

    class ItemHolder(val binding: DailyItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = DailyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemHolder(binding)
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.binding.apply {
            tvDay.text = getItem(position).dt
            tvTempMax.text = getItem(position).temp?.max.toString()
            tvTempMin.text = getItem(position).temp?.min.toString()
            Glide.with(holder.binding.ivIcon.context).load(getItem(position).weather?.get(0)?.icon?.let {
                getIcon(
                    it
                )
            })
                .into(holder.binding.ivIcon)
        }
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