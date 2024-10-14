package com.example.composechat.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.composechat.module.Chat

@Composable
fun ChatItem(
    chat: Chat,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.Gray)
            .clickable { onClick(chat.code) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .padding(10.dp)
            .size(80.dp)
            .background(color = Color.Blue))
        Column(
            modifier = Modifier.fillMaxWidth().padding(0.dp, 6.dp, 10.dp, 6.dp).background(color = Color.Yellow)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = chat.name)
                Text(text = "22:45")
            }
            Text(text = "תחילת הודעה אחרונה")
        }
    }
}