package com.example.composechat.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composechat.module.Chat
import com.example.composechat.ui.MainViewModel
import com.example.composechat.ui.components.ChatItem
import com.example.composechat.ui.components.Route

@Composable
fun MyChatsScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    LazyColumn {
        item {
            ChatItem(
                chat = Chat("שם השיחה", "code"),
                onClick = {
                    navController.navigate(Route.ChatScreen.routeName)
                }
            )
        }
    }
}