package com.appswithlove.coinpose.ui

import androidx.lifecycle.ViewModel
import com.appswithlove.coinpose.R
import com.appswithlove.coinpose.model.Crypto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CoinListViewModel : ViewModel() {

    private val _cryptoItems = MutableStateFlow(getCryptos())
    val cryptoItems: StateFlow<List<Crypto>> = _cryptoItems

    private fun getCryptos(): List<Crypto> {
        return listOf(
            Crypto("Bitcoin", "BTC", 49595.41, 2.62, R.drawable.btc),
            Crypto("Ethereum", "ETH", 1774.90, -0.90, R.drawable.eth),
            Crypto("Cardano", "ADA", 0.8769, 0.99, R.drawable.ada),
            Crypto("Polkadot", "DOT", 29.88, 6.94, R.drawable.dot)
        )
    }
}