package com.appswithlove.coinpose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appswithlove.coinpose.R
import com.appswithlove.coinpose.domain.CoinRepository
import com.appswithlove.coinpose.domain.model.Crypto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(coinRepository: CoinRepository) : ViewModel() {

    private val _cryptoItems = MutableStateFlow(listOf<Crypto>())
    val cryptoItems: StateFlow<List<Crypto>> = _cryptoItems

    private val _selectedCrypto = MutableStateFlow<Crypto?>(null)
    val selectedCrypto: StateFlow<Crypto?> = _selectedCrypto

    init {
        viewModelScope.launch {
            coinRepository.getCrypto().collect { _cryptoItems.emit(it) }
        }
    }

    fun setSelectedCrypto(crypto: Crypto) = viewModelScope.launch {
        _selectedCrypto.emit(crypto)
    }
}