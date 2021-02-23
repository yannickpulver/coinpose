package com.appswithlove.coinpose.ui.coins.list

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
class CoinListViewModel @Inject constructor(coinRepository: CoinRepository) : BaseViewModel() {

    private val _cryptoItems = MutableStateFlow(listOf<Crypto>())
    val cryptoItems: StateFlow<List<Crypto>> = _cryptoItems

    init {
        ioScope.launch {
            coinRepository.getCryptos().collect { _cryptoItems.emit(it) }
        }
    }
}