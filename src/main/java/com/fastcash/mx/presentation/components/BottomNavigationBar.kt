package com.fastcash.mx.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationBar(
    onNavigateToHome: () -> Unit,
    onNavigateToLoans: () -> Unit,
    onNavigateToAccount: () -> Unit
) {
    NavigationBar(
        containerColor = Color(0xFFD9D9D9),
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") },
            selected = false, // Aquí puedes manejar la selección si es necesario
            onClick = onNavigateToHome,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFFFD700), // Color del ícono seleccionado
                unselectedIconColor = Color(0xFF000000), // Color del ícono no seleccionado
                selectedTextColor = Color(0xFFFFD700), // Color del texto seleccionado
                unselectedTextColor = Color(0xFF000000), // Color del texto no seleccionado
//                indicatorColor = Color.Transparent // Color del indicador detrás del ícono seleccionado
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Menu, contentDescription = "Mis Préstamos") },
            label = { Text("Mis Préstamos") },
            selected = false,
            onClick = onNavigateToLoans,
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = Color(0xFF000000), // Color del ícono no seleccionado
                unselectedTextColor = Color(0xFF000000), // Color del texto no seleccionado
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Mi Cuenta") },
            label = { Text("Mi Cuenta") },
            selected = false,
            onClick = onNavigateToAccount,
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = Color(0xFF000000), // Color del ícono no seleccionado
                unselectedTextColor = Color(0xFF000000), // Color del texto no seleccionado
            )
        )
    }
}