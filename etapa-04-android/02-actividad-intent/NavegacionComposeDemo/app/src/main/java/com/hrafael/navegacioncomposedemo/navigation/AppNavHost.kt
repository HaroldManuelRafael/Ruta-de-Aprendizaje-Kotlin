package com.hrafael.navegacioncomposedemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hrafael.navegacioncomposedemo.ui.screens.DetailScreen
import com.hrafael.navegacioncomposedemo.ui.screens.HomeScreen
import com.hrafael.navegacioncomposedemo.ui.screens.ProfileScreen
import com.hrafael.navegacioncomposedemo.ui.screens.ProfileSettingsScreen
import com.hrafael.navegacioncomposedemo.ui.theme.NavegacionComposeDemoTheme

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Home.path,
        modifier = modifier
    ) {
        composable(Route.Home.path) {
            HomeScreen(
                onOpenDetail = { id, name ->
                    navController.navigate(Route.Detail.build(id, name))
                },
                onOpenProfile = { navController.navigate(Route.Profile.path) },
                onOpenSettings = { id, string ->
                    navController.navigate(
                        Route.ProfileSettings.build(
                            id,
                            string
                        )
                    )
                }
            )
        }

        composable(Route.Profile.path) {
            ProfileScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Route.Detail.path,
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: -1
            val name = backStackEntry.arguments?.getString("name")
            DetailScreen(
                id = id,
                name = name,
                onBack = { navController.popBackStack() }
            )

        }

        composable(
            route = Route.ProfileSettings.path,
            arguments = listOf(
                navArgument("userId") { type = NavType.IntType },
                navArgument("tab") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: -1
            val tab = backStackEntry.arguments?.getString("tab") ?: "info"

            ProfileSettingsScreen(
                userId = userId,
                tab = tab,
                onBack = { navController.popBackStack() }
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppNavHostPreview() {
    NavegacionComposeDemoTheme { }
}