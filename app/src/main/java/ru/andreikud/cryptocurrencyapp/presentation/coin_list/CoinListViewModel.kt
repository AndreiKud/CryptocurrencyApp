package ru.andreikud.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.andreikud.cryptocurrencyapp.common.Resource
import ru.andreikud.cryptocurrencyapp.domain.use_case.get_coins.GetCoinUseCase
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value =
                        CoinListState(errorMessage = result.message ?: "Unknown error occurred.")
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}