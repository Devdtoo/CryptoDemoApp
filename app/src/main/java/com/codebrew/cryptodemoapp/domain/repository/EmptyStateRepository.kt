package com.codebrew.cryptodemoapp.domain.repository

import com.codebrew.cryptodemoapp.data.model.response.CryptoResponse
import retrofit2.Response

interface EmptyStateRepository {
    suspend fun getEmptyStateData(): Response<CryptoResponse>
}