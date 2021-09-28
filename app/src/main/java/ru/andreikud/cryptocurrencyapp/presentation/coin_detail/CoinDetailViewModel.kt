package ru.andreikud.cryptocurrencyapp.presentation.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.andreikud.cryptocurrencyapp.common.Constants.PARAM_COIN_ID
import ru.andreikud.cryptocurrencyapp.common.Resource
import ru.andreikud.cryptocurrencyapp.domain.use_case.get_coin.GetCoinDetailUseCase
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        val coinId: String? = savedStateHandle[PARAM_COIN_ID]
        coinId?.let(::getCoinDetail)
    }

    private fun getCoinDetail(coinId: String) {
        getCoinDetailUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value =
                        CoinDetailState(errorMessage = result.message ?: "Unknown error occurred.")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailState(data = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}