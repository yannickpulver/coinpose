package com.appswithlove.coinpose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appswithlove.coinpose.ui.coins.detail.CoinDetail
import com.appswithlove.coinpose.ui.coins.list.CoinList
import com.appswithlove.coinpose.ui.theme.CoinposeTheme
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            CoinposeTheme {
                ProvideWindowInsets {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        AppNavigator()
                    }
                }
            }
        }
    }

    @Composable
    fun AppNavigator() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "coinList") {
            composable("coinList") { CoinList(it.hiltViewModel(), navController) }
            composable("coinDetail/{symbol}") {
                CoinDetail(
                    it.hiltViewModel(),
                    navController,
                    it.arguments?.getString("symbol")
                )
            }
        }
    }
}

@Composable
internal inline fun <reified T : ViewModel> NavBackStackEntry.hiltViewModel(): T {
    return ViewModelProvider(
        this.viewModelStore,
        HiltViewModelFactory(LocalContext.current, this)
    ).get(T::class.java)
}