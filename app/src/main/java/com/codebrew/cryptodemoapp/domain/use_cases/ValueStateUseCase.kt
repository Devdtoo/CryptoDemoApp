package com.codebrew.cryptodemoapp.domain.use_cases

import com.codebrew.cryptodemoapp.data.model.response.CryptoResponse
import com.codebrew.cryptodemoapp.domain.repository.ValueStateRepository
import kotlinx.coroutines.flow.flow
import com.codebrew.cryptodemoapp.common.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ValueStateUseCase @Inject constructor(
    private val valueStateRepository: ValueStateRepository
) {
    operator fun invoke(): Flow<Result<CryptoResponse>> = flow {
        try {
            emit(Result.Loading())
            val response = valueStateRepository.getValueStateData()
            if (response.isSuccessful && response.body() != null) {
                emit(Result.Success(response.body()!!))
            } else {
                emit(Result.Error(message = "Something went wrong."))
            }
        } catch (e: HttpException) {
            emit(Result.Error(message = e.localizedMessage ?: "Something went wrong."))
        } catch (e: IOException) {
            emit(Result.Error(message = e.message ?: "Please check your internet and retry"))
        } catch (e: Exception) {
            emit(Result.Error(message = e.message ?: "Something went wrong."))
        }
    }
}