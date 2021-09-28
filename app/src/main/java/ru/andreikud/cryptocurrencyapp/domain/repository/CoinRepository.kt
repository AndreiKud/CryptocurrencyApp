package ru.andreikud.cryptocurrencyapp.domain.repository

import ru.andreikud.cryptocurrencyapp.data.remote.dto.CoinDto
import ru.andreikud.cryptocurrencyapp.data.remote.dto.detail.CoinDetailDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinDetailById(coinId: String): CoinDetailDto

}