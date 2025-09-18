package com.alness.lifemaster.ui.core.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SmallBodyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        color = color,
        style = style,
        modifier = modifier,
        textAlign = textAlign
    )
}

@Composable
fun MediumBodyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        color = color,
        style = style,
        modifier = modifier,
        textAlign = textAlign
    )
}

@Composable
fun LargeBodyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        color = color,
        style = style,
        modifier = modifier,
        textAlign = textAlign
    )
}


@Composable
fun SmallDisplayText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.displaySmall,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        color = color,
        style = style,
        modifier = modifier,
        textAlign = textAlign
    )
}