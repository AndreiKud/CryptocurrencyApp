package ru.andreikud.cryptocurrencyapp.data.remote.dto.detail


import com.google.gson.annotations.SerializedName

data class Parent(
    val id: String,
    val name: String,
    val symbol: String
)