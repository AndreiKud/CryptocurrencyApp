package ru.andreikud.cryptocurrencyapp.domain.model

import ru.andreikud.cryptocurrencyapp.data.remote.dto.detail.Tag
import ru.andreikud.cryptocurrencyapp.data.remote.dto.detail.TeamMember

class CoinDetail(
    val id: String,
    val name: String,
    val symbol: String,
    val description: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val teamMembers: List<TeamMember>,
)