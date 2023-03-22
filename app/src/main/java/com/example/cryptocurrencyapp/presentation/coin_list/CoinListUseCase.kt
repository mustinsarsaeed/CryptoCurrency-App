package com.example.cryptocurrencyapp.presentation.coin_list

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.data.repository.CoinRepositoryImp
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinListUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Failure(e.localizedMessage ?: "An unexpected Error"))

        } catch (e: IOException) {
            emit(Resource.Failure("Check Internet Connection"))
        }
    }
}