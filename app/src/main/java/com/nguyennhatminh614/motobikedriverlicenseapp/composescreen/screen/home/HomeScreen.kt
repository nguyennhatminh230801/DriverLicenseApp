package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeRoute(modifier: Modifier = Modifier) {
    HomeScreen()
}

@Composable
internal fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "Home")
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}