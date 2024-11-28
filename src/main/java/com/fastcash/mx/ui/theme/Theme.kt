package com.fastcash.mx.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFEF8035), // Amarillo
    onPrimary = Color.Black, // Contraste para texto
    secondary = Color(0xFF19ba00),// Amarillo más claro
    tertiary = Color(0xFF4D7CF2), // Otra variante de amarillo

)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFEF8035), // Amarillo
    onPrimary = Color.Black, // Contraste para texto
    secondary = Color(0xFF19ba00),// Amarillo más claro
    tertiary = Color(0xFF0A74C6), // Otra variante de amarillo

    /* Puedes sobrescribir más colores según necesidad
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.Black, // Para buen contraste en amarillo
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    */
)

@Composable
fun FastCashTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }


//    val window = (view.context as activity)

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
