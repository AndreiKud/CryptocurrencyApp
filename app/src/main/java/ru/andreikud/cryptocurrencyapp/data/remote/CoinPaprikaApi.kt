package ru.andreikud.cryptocurrencyapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import ru.andreikud.cryptocurrencyapp.data.remote.dto.CoinDto
import ru.andreikud.cryptocurrencyapp.data.remote.dto.detail.CoinDetailDto

interface CoinPaprikaApi {

    @GET("/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/coins/{coin_id}")
    suspend fun getCoinById(@Path("coin_id") coinId: String): CoinDetailDto

    companion object {
        const val BASE_URL = "https://api.coinpaprika.com/v1/"
    }
}