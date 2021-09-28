package ru.andreikud.cryptocurrencyapp.domain.use_case.get_coin

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.andreikud.cryptocurrencyapp.common.Resource
import ru.andreikud.cryptocurrencyapp.data.remote.dto.CoinDto
import ru.andreikud.cryptocurrencyapp.domain.model.Coin
import ru.andreikud.cryptocurrencyapp.domain.model.CoinDetail
import ru.andreikud.cryptocurrencyapp.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow<Resource<CoinDetail>> {
        try {
            Log.d("wow", "1")
            emit(Resource.Loading())
            val coinDto = repository.getCoinDetailById(coinId)
            Log.d("wow", "2")
            val coin = coinDto.toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage
                        ?: "An http error occurred."
                )
            )
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