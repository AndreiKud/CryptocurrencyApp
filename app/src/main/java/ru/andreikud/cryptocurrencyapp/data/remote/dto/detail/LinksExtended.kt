package ru.andreikud.cryptocurrencyapp.data.remote.dto.detail


import com.google.gson.annotations.SerializedName

data class LinksExtended(
    val url: String,
    val type: String,
    val stats: Stats
)