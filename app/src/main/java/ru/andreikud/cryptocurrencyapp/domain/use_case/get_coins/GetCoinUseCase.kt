package ru.andreikud.cryptocurrencyapp.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.andreikud.cryptocurrencyapp.common.Resource
import ru.andreikud.cryptocurrencyapp.data.remote.dto.CoinDto
import ru.andreikud.cryptocurrencyapp.domain.model.Coin
import ru.andreikud.cryptocurrencyapp.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coinsDto = repository.getCoins()
            val coins = coinsDto.map(CoinDto::toCoin)
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An http error occurred."))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage
                        ?: "An IO exception occurred. Check your internet connection."
                )
            )
        }
    }
}