package com.appswithlove.coinpose.ui.coins.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appswithlove.coinpose.domain.model.Crypto
import com.appswithlove.coinpose.ui.coins.list.CoinListItem
import com.appswithlove.coinpose.ui.core.Formatter
import com.appswithlove.coinpose.ui.theme.CoinposeTheme
import com.appswithlove.coinpose.ui.theme.downColor
import com.appswithlove.coinpose.ui.theme.upColor
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.statusBarsPadding


@Composable
fun CoinDetail(viewModel: CoinDetailViewModel, navController: NavController, symbol: String?) {
    if (symbol != null) {
        viewModel.getCrypto(symbol)
    } else {
        navController.popBackStack()
    }

    val crypto: Crypto? by viewModel.cryptoItem.collectAsState()

    crypto?.let { CoinContent(navController, it) } ?: Loader()
}

@Composable
private fun CoinContent(navController: NavController, crypto: Crypto) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CoilImage(
                            data = crypto.iconUrl, fadeIn = true,
                            contentDescription = "icon of ${crypto.name}",
                            modifier = Modifier.padding(end = 8.dp).preferredSize(24.dp)
                        )
                        Text(text = crypto.name)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        // below line is use to
                        // specify navigation icon.
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                modifier = Modifier.statusBarsPadding(),
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        ) {
        }

        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(text = Formatter.price(crypto.price), style = MaterialTheme.typography.h2)
            Text(
                text = Formatter.price(crypto.percentChange24h),
                color = if (crypto.isUp) upColor else downColor
            )
        }
    }
}

@Composable
private fun Loader() {
    Box(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCoinContent() {
    CoinposeTheme {
        CoinContent(
            NavController(LocalContext.current),
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