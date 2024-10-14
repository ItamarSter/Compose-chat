package com.example.composechat.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.composechat.R

@Composable
fun SideDrawerDialog(
    title: String,
    hint: String,
    onDismissRequest: () -> Unit
) {
    var textFieldValue by remember { mutableStateOf("") }

    AlertDialog(
        title = {
            Text(text = title)
        },
        text = {
            OutlinedTextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                label = { Text(text = hint) }
            )
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.confirm))
            }
        },
    )
}