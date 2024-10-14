package com.example.composechat.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.composechat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavHostController,
    onNavIconClick: () -> Unit
) {

    var currentScreen by remember { mutableStateOf<Route>(Route.MyChatsScreen) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    when (currentScreen) {
                        Route.MyChatsScreen -> Text(stringResource(id = R.string.my_chats))
                        Route.ChatScreen -> Text(stringResource(id = R.string.chat))
                    }
                },
                navigationIcon = {
                    when (currentScreen) {
                        Route.MyChatsScreen -> {
                            IconButton(onClick = onNavIconClick) {
                                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
                            }
                        }
                        Route.ChatScreen -> {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                            }
                        }
                    }
                }
            )
        },
    ) { innerPadding ->
        MainNavGraph(
            innerPadding,
            navController,
            onRouteChanged = { route -> currentScreen = route }
        )
    }
}