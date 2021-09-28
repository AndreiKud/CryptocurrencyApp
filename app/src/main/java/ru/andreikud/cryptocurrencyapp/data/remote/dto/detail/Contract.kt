package ru.andreikud.cryptocurrencyapp.data.remote.dto.detail


import com.google.gson.annotations.SerializedName

data class Contract(
    val contract: String,
    val platform: String,
    val type: String
)