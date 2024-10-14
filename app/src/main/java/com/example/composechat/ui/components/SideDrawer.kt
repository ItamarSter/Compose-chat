package com.example.composechat.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composechat.R
import com.example.composechat.ui.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@Composable
fun SideDrawer(
    navController: NavHostController,
    drawerState: DrawerState,
    viewModel: MainViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf<SideDrawerOptions>(SideDrawerOptions.None) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(300.dp)
            ) {
                NavigationDrawerItem(
                    label = {
                        Text(text = stringResource(id = R.string.create_new_chat))
                    },
                    shape = RectangleShape,
                    selected = false,
                    onClick = { showDialog = SideDrawerOptions.CreateNewChat }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = stringResource(id = R.string.join_to_chat))
                    },
                    shape = RectangleShape,
                    selected = false,
                    onClick = { showDialog = SideDrawerOptions.JoinToChat }
                )
            }
        }
    ) {
        TopBar(
            navController,
            onNavIconClick = {
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            }
        )
        when (showDialog) {
            SideDrawerOptions.None -> {}
            SideDrawerOptions.CreateNewChat -> {
                SideDrawerDialog(
                    title = stringResource(id = R.string.create_new_chat),
                    hint = stringResource(id = R.string.enter_new_chat_name),
                    onDismissRequest = { showDialog = SideDrawerOptions.None },
                    onConfirm = { newChatName ->
                        viewModel.createNewChat(newChatName)
                    }
                )
            }
            SideDrawerOptions.JoinToChat -> {
                SideDrawerDialog(
                    title = stringResource(id = R.string.join_to_chat),
                    hint = stringResource(id = R.string.enter_chat_code),
                    onDismissRequest = { showDialog = SideDrawerOptions.None },
                    onConfirm = { chatCode ->
                        viewModel.joinToChat(chatCode)
                    }
                )
            }
        }
    }
}


sealed class SideDrawerOptions {
    data object CreateNewChat : SideDrawerOptions()
    data object JoinToChat : SideDrawerOptions()
    data object None : SideDrawerOptions()
}