package com.fastcash.mx.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fastcash.mx.R
import com.fastcash.mx.presentation.viewmodels.SignupState

@Composable
fun AboutScreen(
    navController: NavHostController,
    padding: PaddingValues,
) {
    val scrollState = rememberScrollState()

    val annotatedString = buildAnnotatedString {
        // Subrayar el primer texto ("Terms of Use")
        pushStyle(
            MaterialTheme.typography.bodyLarge.toSpanStyle().copy(
                fontSize = 14.sp, textDecoration = TextDecoration.Underline // Aplica subrayado
            )
        )
        pushStringAnnotation(tag = "login", annotation = "login")

        append("Terms of Use")
        pop() // Vuelve al estilo anterior

        append("  •  ") // Separador sin subrayado

        // Subrayar el último texto ("Privacy Policy")
        pushStyle(
            MaterialTheme.typography.bodyLarge.toSpanStyle().copy(
                fontSize = 14.sp, textDecoration = TextDecoration.Underline // Aplica subrayado
            )
        )
        pushStringAnnotation(tag = "privacy_policy", annotation = "privacy_policy")
        append("Privacy Policy")
        pop()
    }


    val annotatedString2 = buildAnnotatedString {
        append("Ya tienes una cuenta? ")  // El texto antes de la última palabra
        pushStyle(MaterialTheme.typography.bodyLarge.toSpanStyle().copy(fontSize = 14.sp))
        pop()  // Vuelve al estilo anterior
        pushStyle(
            MaterialTheme.typography.bodyLarge.toSpanStyle().copy(
                fontSize = 14.sp, textDecoration = TextDecoration.Underline // Aplicar subrayado
            )
        )
        append("Iniciar Sesión")  // Aplicar el subrayado a esta última palabra
    }


    Image(
        painter = painterResource(id = R.drawable.bg2),
        contentDescription = "Background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFCBCBCB),
                        Color(0xFFCBCBCB)
                    )
                )
            ),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.logo), // Reemplaza con tu recurso de imagen
            contentDescription = "Imagen de ejemplo", // Descripción para accesibilidad
            modifier = Modifier
                .width(100.dp)
                .height(100.dp), // Ajusta la altura de la imagen
            contentScale = ContentScale.Crop // Escala la imagen para que llene el espacio recortándola
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Versión de la aplicación: 1.0.0",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp, // Aumenta el tamaño de la fuente a 24sp
                color = Color.Black // Establece el color del texto a blanco
            ),
//            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Perfil de la empresa",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp, // Aumenta el tamaño de la fuente a 24sp
                color = Color.Black, // Establece el color del texto a blanco
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Left, // Alineación del texto
            modifier = Modifier.fillMaxWidth() // Asegura que ocupe todo el ancho disponible
                    .padding(horizontal = 16.dp)

        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Fast Cash es una empresa dedicada a ofrecer soluciones financieras rápidas y confiables. Especializada en préstamos personales y empresariales, se enfoca en brindar acceso inmediato a capital con procesos simples, tasas competitivas y plazos flexibles. Su compromiso es apoyar a sus clientes en momentos de necesidad, garantizando un servicio transparente y accesible para impulsar su bienestar económico y sus proyectos financieros.",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp, // Aumenta el tamaño de la fuente a 24sp
                color = Color.Black // Establece el color del texto a blanco
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )








    }

}
