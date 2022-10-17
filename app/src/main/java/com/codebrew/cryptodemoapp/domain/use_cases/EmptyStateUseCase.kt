package com.codebrew.cryptodemoapp.domain.use_cases

import android.util.Log
import com.codebrew.cryptodemoapp.common.Result
import com.codebrew.cryptodemoapp.data.model.response.CryptoResponse
import com.codebrew.cryptodemoapp.domain.repository.EmptyStateRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class EmptyStateUseCase @Inject constructor(
    private val emptyStateRepository: EmptyStateRepository
) {
    suspend operator fun invoke(): Result<CryptoResponse> =
        try {
            Result.Loading<CryptoResponse>()
            val response = emptyStateRepository.getEmptyStateData()
            Log.d("API_LOGGER", response.toString())
            if (response.isSuccessful && response.body() != null) {
                Log.d("API_LOGGER", "Success")
                Result.Success(response.body()!!)
            } else {
                Log.d("API_LOGGER", "Failed ${response.errorBody()}")
                Result.Error(message = "Something went wrong.")
            }
        } catch (e: HttpException) {
            Log.d("API_LOGGER", "HttpException}")
            Result.Error(message = e.localizedMessage ?: "Something went wrong.")
        } catch (e: IOException) {
            Log.d("API_LOGGER", "IOException}")
            Result.Error(message = e.message ?: "Please check your internet and retry")
        }
}
