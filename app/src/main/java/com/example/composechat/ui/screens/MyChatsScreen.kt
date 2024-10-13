package com.example.composechat.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composechat.R
import com.example.composechat.ui.MainViewModel

@Composable
fun MyChatsScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    Text(text = stringResource(id = R.string.my_chats))
}