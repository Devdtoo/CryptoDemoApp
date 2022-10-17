package com.codebrew.cryptodemoapp.presentation.screens.empty_state_detail.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codebrew.cryptodemoapp.data.model.response.CryptoResponse
import com.codebrew.cryptodemoapp.domain.use_cases.EmptyStateUseCase
import com.codebrew.cryptodemoapp.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoEmptyViewModel @Inject constructor(
    private val emptyStateUseCase: EmptyStateUseCase
): ViewModel() {

    private val _state = MutableLiveData<Result<CryptoResponse>>()
    val state get() = _state



    fun getEmptyStateData() {
        viewModelScope.launch(Dispatchers.IO) {
            val cryptoData = emptyStateUseCase()
            _state.postValue(cryptoData)
        }

    }

}