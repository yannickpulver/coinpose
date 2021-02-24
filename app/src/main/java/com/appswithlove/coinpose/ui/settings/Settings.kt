package com.appswithlove.coinpose.ui.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.appswithlove.coinpose.ui.coins.AppBottomNavigation
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun Settings(navController: NavHostController) {
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
        Text(text = "Settings")
    }
}
