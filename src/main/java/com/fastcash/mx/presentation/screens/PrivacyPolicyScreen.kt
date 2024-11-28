package com.fastcash.mx.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fastcash.mx.R

@Composable
fun PrivacyPolicyScreen(
    navController: NavHostController,
    padding: PaddingValues,
) {
    val scrollState = rememberScrollState()



    Image(
        painter = painterResource(id = R.drawable.bg2),
        contentDescription = "Background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFCBCBCB),
                        Color(0xFFCBCBCB)
                    )
                )
            )
    ) {
        Text(
            text = "Instrucciones de acceso a datos de\nprivacidad",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            textAlign = TextAlign.Center, // Centra las líneas del texto
            modifier = Modifier
                .padding(top = 70.dp) // Margen inferior
                .fillMaxWidth() // Asegura que el texto ocupe todo el ancho disponible
        )


        // Aquí va el contenido de tus políticas
        Text(
            text = """
Para ofrecerte una experiencia integral, segura y
compleamente adaaptda a tus necesidades
financieras, FAST CASH necesita ciertos permisos
en u dispositivo. Estos permisosson esenciales
para que podamos crear un perfil financiero solido
y proporcionarte un servicio agil, personalizado y
confiable. A continuacion, detallamos cada uno de
Estos permisos y la importancia de otorgarlos:
""",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 12.sp, // Aumenta el tamaño de la fuente a 24sp
                color = Color.White // Establece el color del texto a blanco
            ),
            modifier = Modifier
                .padding(bottom = 0.dp)
                .padding(horizontal = 30.dp)
        )
        Text(
            text = """SMS: Fast Cash solicita acceso a tus mensajes para optimizar varios aspectos de tu perfil  financiero, Este permiso nos permite: - Generar archivos finaniceros basados es el  analisis de tus transacciones, como ingresos y egresos que se reflejan en notificaciones bancarias o de servicios financieros. - Ejecutar operaciones de credito de manera automatica para calcular tus ingresos de forma confiable y adaptar tu limite de credito acorde  a tu realidad econimica. - Verificar tu identidad de forma automatica mediante codigos de verificacion recibidos por SMS, agilixando el proceso de seguridad sin que tengas que ingresar datos manual mente.

""",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 12.sp, // Aumenta el tamaño de la fuente a 24sp
                color = Color.White // Establece el color del texto a blanco
            ),
            modifier = Modifier
                .padding(bottom = 0.dp)
                .padding(horizontal = 30.dp)
        )


        // Botón para navegar hacia atrás
//        Button(
//            onClick = {
//                navController.popBackStack() // Navega hacia atrás
//            },
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        ) {
//            Text(text = "Volver")
//        }
    }

}
