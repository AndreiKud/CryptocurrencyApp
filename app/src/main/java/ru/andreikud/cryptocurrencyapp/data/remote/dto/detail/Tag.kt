package ru.andreikud.cryptocurrencyapp.data.remote.dto.detail


import com.google.gson.annotations.SerializedName

data class Tag(
    val id: String,
    val name: String,
    @SerializedName("coin_counter") val coinCounter: Int,
    @SerializedName("ico_counter") val icoCounter: Int
)