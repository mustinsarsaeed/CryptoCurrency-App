package com.example.cryptocurrencyapp.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoin() : List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coidId") coinId : String) : CoinDetailDto
}