package com.appswithlove.coinpose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.appswithlove.coinpose.domain.model.Crypto
import com.appswithlove.coinpose.ui.theme.CoinposeTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import java.text.DecimalFormat

@Composable
fun CoinList(viewModel: CoinListViewModel, navController: NavController) {

    val cryptos: List<Crypto> by viewModel.cryptoItems.collectAsState()

    LazyColumn {
        items(cryptos) {
            Box(modifier = Modifier.clickable {
                viewModel.setSelectedCrypto(it)
                navController.navigate("coinDetail")
            }) {
                CoinListItem(it)
            }
        }
    }
}


@Composable
fun CoinListItem(crypto: Crypto) {
    val dec = DecimalFormat("#,##0.00")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 12.dp)
        ) {
            CoilImage(
                data = crypto.iconUrl, fadeIn = true,
                contentDescription = "icon of ${crypto.name}",
                modifier = Modifier
                    .preferredSize(24.dp)
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(text = crypto.name)
            Text(text = crypto.symbol)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "$${dec.format(crypto.price)}")
            Text(text = "${dec.format(crypto.percentChange24h)}%")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCoinListItem() {
    CoinposeTheme {
        CoinListItem(
            Crypto(
                "Bitcoin",
                "BTC",
                49595.0,
                2.62,
                "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"
            )
        )
    }
}