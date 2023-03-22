package com.example.cryptocurrencyapp.presentation.coin_detail

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.example.cryptocurrencyapp.domain.model.CoinDetail
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val repository : CoinRepository
) {
    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        }catch (e : HttpException) {
            emit(Resource.Failure(e.localizedMessage ?: "An UnExpected Error"))

        } catch (e: IOException) {
            emit(Resource.Failure("Check Your Internet Connection"))

        }
    }
}