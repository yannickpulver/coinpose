package com.appswithlove.coinpose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appswithlove.coinpose.ui.theme.CoinposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CoinListItem()
                }
            }
        }
    }
}

@Composable
fun CoinListItem() {
    val image = vectorResource(R.drawable.btc)
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 16.dp)) {
        Column(modifier = Modifier.align(Alignment.CenterVertically).padding(end = 12.dp)) {
            Image(image, modifier = Modifier.preferredSize(24.dp))
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Bitcoin")
            Text(text = "BTC")
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "$49595")
            Text(text = "+2.62%")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoinposeTheme {
        CoinListItem()
    }
}