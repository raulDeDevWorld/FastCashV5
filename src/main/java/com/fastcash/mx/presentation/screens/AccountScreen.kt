package com.fastcash.mx.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.TextFields
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fastcash.mx.R

@Composable
fun NavigationButton(
    title: String,
    icon: ImageVector,
    onNavigate: () -> Unit
) {
    // Botón con icono y texto
    Button(
        onClick = onNavigate,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(vertical = 10.dp)
            .padding(horizontal = 30.dp)
        ,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD9D9D9)),
//        elevation = ButtonDefaults.elevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Ícono
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Título
            Text(
                text = title,
                fontSize = 13.sp, // Tamaño del texto aumentado
                style = MaterialTheme.typography.labelSmall.copy(color = Color.Black),
            )

            // Flecha a la derecha
            Icon(
                imageVector =  Icons.Outlined.ArrowForward,
                contentDescription = "Ir",
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
        }
    }
}

@Composable
fun AccountScreen(
    padding: PaddingValues,
    onNavigateToQuejas: () -> Unit,
    onNavigateToNosotros: () -> Unit,
    onNavigateToPolitica: () -> Unit,
    onNavigateToTarjeta: () -> Unit,
    onNavigateToHistorial: () -> Unit
) {

    Image(
        painter = painterResource(id = R.drawable.bg2),
        contentDescription = "Background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(padding)
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFCBCBCB),
                    Color(0xFFCBCBCB)
                )
            )
        )) {

        Spacer(modifier = Modifier.height(40.dp))

        NavigationButton(
            title = "Quejas del Usuario",
            icon = Icons.Outlined.AccountCircle,
            onNavigate = onNavigateToQuejas
        )
        Spacer(modifier = Modifier.height(8.dp))

        NavigationButton(
            title = "Sobre Nosotros",
            icon = Icons.Outlined.Info,
            onNavigate = onNavigateToNosotros
        )
        Spacer(modifier = Modifier.height(8.dp))

        NavigationButton(
            title = "Política de Privacidad",
            icon = Icons.Outlined.Lock,
            onNavigate = onNavigateToPolitica
        )
        Spacer(modifier = Modifier.height(8.dp))

        NavigationButton(
            title = "Tarjeta Bancaria",
            icon = Icons.Filled.CreditCard,
            onNavigate = onNavigateToTarjeta
        )
        Spacer(modifier = Modifier.height(8.dp))

        NavigationButton(
            title = "Historial de Préstamos",
            icon = Icons.Filled.ContentPaste,
            onNavigate = onNavigateToHistorial
        )
        Spacer(modifier = Modifier.height(8.dp))


        // Botón de registro
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 8.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD32F2F), // Color rojo para indicar acción de cerrar sesión
                contentColor = Color.White // Texto e ícono blancos
            ),
            shape = RoundedCornerShape(8.dp) // Esquinas redondeadas
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Cerrar sesión",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Icon(
                    imageVector = Icons.Default.ExitToApp, // Icono predeterminado para salir
                    contentDescription = "Cerrar sesión",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
