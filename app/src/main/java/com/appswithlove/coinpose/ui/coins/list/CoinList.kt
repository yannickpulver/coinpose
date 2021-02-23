package com.appswithlove.coinpose.ui.coins.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.appswithlove.coinpose.domain.model.Crypto
import com.appswithlove.coinpose.ui.theme.CoinposeTheme
import com.appswithlove.coinpose.ui.theme.downColor
import com.appswithlove.coinpose.ui.theme.upColor
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import java.text.DecimalFormat

@Composable
fun CoinList(viewModel: CoinListViewModel, navController: NavController) {

    val cryptos: List<Crypto> by viewModel.cryptoItems.collectAsState()

    Box(modifier = Modifier.statusBarsPadding()) {
        LazyColumn {
            itemsIndexed(cryptos) { index, crypto ->
                Box(modifier = Modifier.clickable {
                    navController.navigate("coinDetail/${crypto.symbol}")
                }) {
                    CoinListItem(crypto)
                    if (index < cryptos.size - 1) {
                        Divider(thickness = 1.dp)
                    }
                }
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
            Text(text = crypto.name, style = MaterialTheme.typography.h4)
            Text(text = crypto.symbol)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "$${dec.format(crypto.price)}", style = MaterialTheme.typography.h4)
            Text(
                text = "${dec.format(crypto.percentChange24h)}%",
                color = if (crypto.isUp) upColor else downColor
            )
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