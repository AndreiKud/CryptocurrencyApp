package ru.andreikud.cryptocurrencyapp.data.repository

import ru.andreikud.cryptocurrencyapp.data.remote.CoinPaprikaApi
import ru.andreikud.cryptocurrencyapp.data.remote.dto.CoinDto
import ru.andreikud.cryptocurrencyapp.data.remote.dto.detail.CoinDetailDto
import ru.andreikud.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = api.getCoins()

    override suspend fun getCoinDetailById(coinId: String): CoinDetailDto = api.getCoinById(coinId)
}