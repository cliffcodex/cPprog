package com.west.%.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Dark mode colors
private val DarkColors = darkColorScheme(
    primary = Color(0xFF1EB980), // Green
    secondary = Color(0xFF045D56), // Dark green
    background = Color(0xFF121212), // Dark background
    surface = Color(0xFF1E1E1E), // Dark surface
    onPrimary = Color.White, // White text on primary
    onSecondary = Color.White, // White text on secondary
    onBackground = Color.White, // White text on background
    onSurface = Color.White // White text on surface
)

// Light mode colors
private val LightColors = lightColorScheme(
    primary = Color(0xFF00695C), // Dark teal
    secondary = Color(0xFF004D40), // Darker teal
    background = Color(0xFFF0F0F0), // Light background
    surface = Color.White, // White surface
    onPrimary = Color.White, // White text on primary
    onSecondary = Color.White, // White text on secondary
    onBackground = Color.Black, // Black text on background
    onSurface = Color.Black // Black text on surface
)

@Composable
fun %(
    darkTheme: Boolean = isSystemInDarkTheme(), // Automatically use system theme
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors // Switch color scheme based on system theme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(), // Use the default Material typography
        content = content
    )
}
