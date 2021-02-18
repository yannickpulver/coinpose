package com.appswithlove.coinpose.ui

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.appswithlove.coinpose.domain.model.Crypto


@Composable
fun CoinDetail(viewModel: CoinListViewModel) {
    val crypto: Crypto? by viewModel.selectedCrypto.collectAsState()

    if (crypto != null) {
        CoinListItem(crypto = crypto!!)
    } else {
        CircularProgressIndicator()
    }
}