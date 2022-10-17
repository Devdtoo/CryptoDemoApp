package com.codebrew.cryptodemoapp.data.repo

import com.codebrew.cryptodemoapp.data.model.response.CryptoResponse
import com.codebrew.cryptodemoapp.data.remote.ApiService
import com.codebrew.cryptodemoapp.domain.repository.ValueStateRepository
import retrofit2.Response
import javax.inject.Inject

class ValueStateRepositoryImpl @Inject constructor(
    val apiService: ApiService
) : ValueStateRepository {

    override suspend fun getValueStateData(): Response<CryptoResponse> = apiService.getValueStateApiData()

}