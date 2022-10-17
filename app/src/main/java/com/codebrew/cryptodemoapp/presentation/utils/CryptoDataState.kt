package com.codebrew.cryptodemoapp.presentation.utils

import com.codebrew.cryptodemoapp.data.model.response.CryptoResponse

data class CryptoDataState(
    val isLoading: Boolean = false,
    val cryptoData: CryptoResponse? = null,
    val error: String = ""
)
