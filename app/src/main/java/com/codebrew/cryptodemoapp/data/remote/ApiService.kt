package com.codebrew.cryptodemoapp.data.remote

import com.codebrew.cryptodemoapp.data.model.response.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/home")
    suspend fun getValueStateApiData(): Response<CryptoResponse>

    @GET("/empty-home")
    suspend fun getEmptyStateApiData(): Response<CryptoResponse>
}