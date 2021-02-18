package com.appswithlove.coinpose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appswithlove.coinpose.ui.CoinDetail
import com.appswithlove.coinpose.ui.CoinList
import com.appswithlove.coinpose.ui.CoinListViewModel
import com.appswithlove.coinpose.ui.theme.CoinposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
            composable("coinList") { CoinList(it.hiltViewModel(), navController) }
            composable("coinDetail") { CoinDetail(it.hiltViewModel()) }
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