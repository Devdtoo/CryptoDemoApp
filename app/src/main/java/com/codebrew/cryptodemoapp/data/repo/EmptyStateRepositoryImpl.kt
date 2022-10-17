package com.codebrew.cryptodemoapp.data.repo

import com.codebrew.cryptodemoapp.data.model.response.CryptoResponse
import com.codebrew.cryptodemoapp.data.remote.ApiService
import com.codebrew.cryptodemoapp.domain.repository.EmptyStateRepository
import retrofit2.Response
import javax.inject.Inject

class EmptyStateRepositoryImpl @Inject constructor(
    val apiService: ApiService
) : EmptyStateRepository {

    override suspend fun getEmptyStateData(): Response<CryptoResponse> = apiService.getEmptyStateApiData()
}