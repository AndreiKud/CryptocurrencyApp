package ru.andreikud.cryptocurrencyapp.presentation.coin_detail

import ru.andreikud.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val data: CoinDetail? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = "",
)