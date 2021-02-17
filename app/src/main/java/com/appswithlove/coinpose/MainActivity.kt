package com.appswithlove.coinpose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appswithlove.coinpose.ui.CoinDetail
import com.appswithlove.coinpose.ui.CoinList
import com.appswithlove.coinpose.ui.theme.CoinposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AppNavigator()
                }
            }
        }
    }

    @Composable
    fun AppNavigator() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "coinList") {
            composable("coinList") { CoinList(navController) }
            composable("coinDetail") { CoinDetail() }
        }
    }
}