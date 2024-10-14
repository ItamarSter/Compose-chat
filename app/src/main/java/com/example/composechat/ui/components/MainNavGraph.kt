package com.example.composechat.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composechat.ui.screens.ChatScreen
import com.example.composechat.ui.screens.MyChatsScreen

@Composable
fun MainNavGraph(
    innerPaddingValues: PaddingValues,
    navController: NavHostController
) {

    NavHost(modifier = Modifier.padding(innerPaddingValues), navController = navController, startDestination = "MyChatsScreen") {
        composable("MyChatsScreen") {
            MyChatsScreen(navController = navController)
        }
        composable("ChatScreen") {
            ChatScreen(navController = navController)
        }
    }
}