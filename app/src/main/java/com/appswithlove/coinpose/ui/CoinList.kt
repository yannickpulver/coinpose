package com.appswithlove.coinpose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.appswithlove.coinpose.R
import com.appswithlove.coinpose.model.Crypto
import com.appswithlove.coinpose.ui.theme.CoinposeTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun CoinList(navController: NavController, viewModel: CoinListViewModel = viewModel()) {
    val cryptos: List<Crypto> by viewModel.cryptoItems.collectAsState()

    LazyColumn {
        items(cryptos) {
            Box(modifier = Modifier.clickable { navController.navigate("coinDetail") }) {
                CoinListItem(it)
            }
        }
    }
}

@Composable
fun CoinListItem(crypto: Crypto) {
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
            Image(
                painterResource(crypto.icon),
                contentDescription = "icon of ${crypto.name}",
                modifier = Modifier
                    .background(Color.White, shape = CircleShape)
                    .preferredSize(24.dp)
                    .padding(4.dp)
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(text = crypto.name)
            Text(text = crypto.symbol)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "$${crypto.price}")
            Text(text = "${crypto.percentChange24h}%")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewCoinListItem() {
    CoinposeTheme {
        CoinListItem(Crypto("Bitcoin", "BTC", 49595.0, 2.62, R.drawable.btc))
    }
}