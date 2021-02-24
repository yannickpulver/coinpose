package com.appswithlove.coinpose.ui.portfolio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.appswithlove.coinpose.domain.model.Crypto
import com.appswithlove.coinpose.ui.coins.AppBottomNavigation
import com.appswithlove.coinpose.ui.coins.BottomNavigationScreens
import com.appswithlove.coinpose.ui.coins.list.CoinListItem
import com.appswithlove.coinpose.ui.coins.list.CoinListViewModel
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun Portfolio(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Coinpose")
                    }
                },
                modifier = Modifier.statusBarsPadding(),
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background
            )
        },
        bottomBar = { AppBottomNavigation(navController) }
    ) {
        Text(text = "Portfolio")
    }
}
