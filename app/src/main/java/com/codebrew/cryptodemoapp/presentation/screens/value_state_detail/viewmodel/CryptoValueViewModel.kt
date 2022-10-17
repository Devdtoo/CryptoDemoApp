package com.codebrew.cryptodemoapp.presentation.screens.value_state_detail.viewmodel

import androidx.lifecycle.ViewModel
import com.codebrew.cryptodemoapp.domain.use_cases.ValueStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoValueViewModel @Inject constructor(
    private val valueStateUseCase: ValueStateUseCase
): ViewModel() {


   /* init {
        getValueStateData()
    }

    private fun getValueStateData() {
        valueStateUseCase().onEach { result ->
            when(result) {
                is Result.Success -> _state.value = CryptoDataState(cryptoData = result.data)
                is Result.Error -> _state.value = CryptoDataState(error = result.message?: "Something went wrong")
                is Result.Loading -> _state.value = CryptoDataState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }*/

}