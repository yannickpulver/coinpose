package com.appswithlove.coinpose.ui.coins.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appswithlove.coinpose.domain.CoinRepository
import com.appswithlove.coinpose.domain.model.Crypto
import com.appswithlove.coinpose.ui.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(val coinRepository: CoinRepository) : BaseViewModel() {

    private val _cryptoItem: MutableStateFlow<Crypto?> = MutableStateFlow(null)
    val cryptoItem: StateFlow<Crypto?> = _cryptoItem


    fun getCrypto(symbol: String) = ioScope.launch {
        coinRepository.getCrypto(symbol).collect { _cryptoItem.emit(it) }
    }
}