package com.alness.lifemaster.ui.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.alness.lifemaster.R



@Composable
fun EmailEditText(value: String, labelText: String, onValue: (String) -> Unit, onClearText: (String) -> Unit){
    OutlinedTextField(
        value = value,
        onValueChange = { onValue(it)  },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        label = { Text(labelText) },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = { onClearText(value) }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                }
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
    )
}

@Composable
fun PasswordEditText(value: String, labelText: String, onValue: (String) -> Unit, isVisible: Boolean, onVisibleText: (Boolean) -> Unit){
    OutlinedTextField(
        value = value,
        onValueChange = { onValue(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        label = { Text(labelText) },
        trailingIcon = {
            IconButton(onClick = { onVisibleText(isVisible) }) {
                Icon(
                    painter = painterResource(id = if(isVisible) R.drawable.visibility_off_24dp else R.drawable.visibility_24dp),
                    contentDescription = if (isVisible) "Hide password" else "Show password"
                )
            }
        },
        singleLine = true,
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        )
    )
}
