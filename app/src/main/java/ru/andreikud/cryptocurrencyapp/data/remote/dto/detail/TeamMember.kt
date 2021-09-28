package ru.andreikud.cryptocurrencyapp.data.remote.dto.detail


import com.google.gson.annotations.SerializedName

data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)