package com.example.composechat.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composechat.R
import kotlinx.coroutines.launch

@Composable
fun SideDrawer(
    navController: NavHostController,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
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
                    onClick = { }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = stringResource(id = R.string.join_to_chat))
                    },
                    shape = RectangleShape,
                    selected = false,
                    onClick = { }
                )
            }
        }
    ) {
        Column {
            IconButton(onClick = {
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
            MainNavGraph(navController)
        }
    }
}