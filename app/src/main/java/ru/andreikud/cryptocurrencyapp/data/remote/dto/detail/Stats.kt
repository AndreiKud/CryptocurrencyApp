package ru.andreikud.cryptocurrencyapp.data.remote.dto.detail


import com.google.gson.annotations.SerializedName

data class Stats(
    val subscribers: Int,
    val contributors: Int,
    val stars: Int
)