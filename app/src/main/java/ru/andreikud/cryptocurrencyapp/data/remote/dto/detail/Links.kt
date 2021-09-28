package ru.andreikud.cryptocurrencyapp.data.remote.dto.detail


import com.google.gson.annotations.SerializedName

data class Links(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    @SerializedName("source_code") val sourceCode: List<String>,
    val website: List<String>,
    val youtube: List<String>,
    val medium: Any
)