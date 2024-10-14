package com.example.composechat.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composechat.R
import com.example.composechat.module.Chat
import com.example.composechat.ui.MainViewModel
import com.example.composechat.ui.components.ChatItem

@Composable
fun MyChatsScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    LazyColumn {
        item {
            ChatItem(Chat("שם השיחה"))
        }
    }
}