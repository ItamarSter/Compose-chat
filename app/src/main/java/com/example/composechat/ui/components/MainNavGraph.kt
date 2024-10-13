package com.example.composechat.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composechat.ui.screens.ChatScreen
import com.example.composechat.ui.screens.MyChatsScreen

@Composable
fun MainNavGraph(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = "MyChatsScreen") {
        composable("MyChatsScreen") {
            MyChatsScreen(navController = navController)
        }
        composable("ChatScreen") {
            ChatScreen(navController = navController)
        }
    }
}