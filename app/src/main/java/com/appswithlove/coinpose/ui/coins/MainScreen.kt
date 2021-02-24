package com.appswithlove.coinpose.ui.coins

import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import com.appswithlove.coinpose.R
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object CoinList :
        BottomNavigationScreens("coinList", R.string.coinlist_route, Icons.Filled.List)

    object Portfolio :
        BottomNavigationScreens("portfolio", R.string.portfolio_route, Icons.Filled.Home)

    object More :
        BottomNavigationScreens("settings", R.string.settings_route, Icons.Filled.Settings)
}

val bottomNavigationItems = listOf(
    BottomNavigationScreens.CoinList,
    BottomNavigationScreens.Portfolio,
    BottomNavigationScreens.More
)

@Composable
fun AppBottomNavigation(
    navController: NavHostController
) {
    BottomNavigation(modifier = Modifier.navigationBarsPadding()) {
        val currentRoute = currentRoute(navController)
        bottomNavigationItems.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, " ") },
                label = { Text(stringResource(id = screen.resourceId)) },
                selected = currentRoute == screen.route,
                alwaysShowLabels = false, // This hides the title for the unselected items
                onClick = {
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}