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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.alness.lifemaster.R

@Composable
fun EmailEditText(value: String, labelText: String, onValueChange: (String) -> Unit){
    val isValid = value.isEmpty() || android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it)  },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        label = { Text(labelText) },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = { onValueChange("") }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                }
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        isError = value.isNotEmpty() && !isValid
    )
}

@Composable
fun PasswordEditText(value: String, labelText: String, onValueChange: (String) -> Unit){
    var isVisible: Boolean by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        label = { Text(labelText) },
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
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
