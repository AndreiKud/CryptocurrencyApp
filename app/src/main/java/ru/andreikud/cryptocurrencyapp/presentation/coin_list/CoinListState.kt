package ru.andreikud.cryptocurrencyapp.presentation.coin_list

import ru.andreikud.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val data: List<Coin> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)
