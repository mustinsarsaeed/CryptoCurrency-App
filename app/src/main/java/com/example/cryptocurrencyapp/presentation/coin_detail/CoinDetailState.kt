package com.example.cryptocurrencyapp.presentation.coin_detail

import com.example.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    var isLoading : Boolean = false,
    var coin : CoinDetail? = null,
    var error : String = ""
)
