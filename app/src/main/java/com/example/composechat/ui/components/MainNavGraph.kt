package com.example.composechat.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composechat.ui.screens.ChatScreen
import com.example.composechat.ui.screens.MyChatsScreen

@Composable
fun MainNavGraph(
    innerPaddingValues: PaddingValues,
    navController: NavHostController,
    onRouteChanged: (Route) -> Unit
) {

    NavHost(modifier = Modifier.padding(innerPaddingValues), navController = navController, startDestination = "MyChatsScreen") {
        composable(Route.MyChatsScreen.routeName) {
            onRouteChanged(Route.MyChatsScreen)
            MyChatsScreen(navController = navController)
        }
        composable(Route.ChatScreen.routeName) {
            onRouteChanged(Route.ChatScreen)
            ChatScreen(navController = navController)
        }
    }
}

sealed class Route(val routeName: String) {
    data object MyChatsScreen: Route("MyChatsScreen")
    data object ChatScreen: Route("ChatScreen")
}