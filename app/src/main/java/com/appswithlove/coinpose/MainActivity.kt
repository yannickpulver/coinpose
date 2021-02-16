package com.appswithlove.coinpose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appswithlove.coinpose.model.Crypto
import com.appswithlove.coinpose.ui.theme.CoinposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cryptos = getCryptos()
        setContent {
            CoinposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn {
                        items(cryptos) {
                            CoinListItem(it)
                        }
                    }
                }
            }
        }
    }

    private fun getCryptos(): List<Crypto> {
        return listOf(
            Crypto("Bitcoin", "BTC", 49595.41, 2.62, R.drawable.btc),
            Crypto("Ethereum", "ETH", 1774.90, -0.90, R.drawable.eth),
            Crypto("Cardano", "ADA", 0.8769, 0.99, R.drawable.ada),
            Crypto("Polkadot", "DOT", 29.88, 6.94, R.drawable.dot)
        )
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
            Image(vectorResource(crypto.icon), modifier = Modifier.background(Color.White, shape = CircleShape).preferredSize(24.dp))
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