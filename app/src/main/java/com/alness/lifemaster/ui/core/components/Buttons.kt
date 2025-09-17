package com.alness.lifemaster.ui.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(onClick: ()-> Unit, labelButton: String){
    Button(onClick, modifier = Modifier.fillMaxWidth()
        .padding(bottom = 8.dp)) {
        Text(labelButton)
    }
}