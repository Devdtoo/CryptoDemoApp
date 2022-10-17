package com.codebrew.cryptodemoapp.domain.repository

import com.codebrew.cryptodemoapp.data.model.response.CryptoResponse
import retrofit2.Response

interface ValueStateRepository {
    suspend fun getValueStateData(): Response<CryptoResponse>
}