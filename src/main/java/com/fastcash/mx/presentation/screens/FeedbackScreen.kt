package com.fastcash.mx.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.fastcash.mx.R

@Composable
fun FeedbackScreen(
    navController: NavHostController,
    padding: PaddingValues,
    onSendMessage: (String) -> Unit
) {
    // Estado para el texto del mensaje
    var messageText by remember { mutableStateOf("Escribe algo...") }


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
            )
    ) {





        // Campo de entrada de texto
        Box(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho
                .fillMaxHeight(0.5f) // Ocupa la mitad del alto
//                .background(Color(0xFFE0E0E0)) // Fondo gris claro
                .padding(horizontal = 0.dp) // Margen lateral

        ) {
            OutlinedTextField(
                value = messageText,
                onValueChange = { messageText = it },
                label = { Text("Escribe tu mensaje") },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp) // Ajusta el campo de texto al contenedor
                    .background(Color(0xFFE0E0E0)),
                maxLines = 2,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, // Texto negro cuando está enfocado
                    unfocusedTextColor = Color.Black, // Texto negro cuando no está enfocado
                    focusedBorderColor = Color.Black, // Borde negro cuando está enfocado
                    unfocusedBorderColor = Color(0xFFD9D9D9), // Borde gris cuando no está enfocado
                    cursorColor = Color(0xFFD9D9D9), // Cursor gris
                    unfocusedLabelColor = Color(0xFFD9D9D9) // Etiqueta gris cuando no está enfocado
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para enviar el mensaje
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth().padding(top= 10.dp).height(55.dp) // Ajusta la altura aquí
                .padding(horizontal = 18.dp).padding(bottom = 10.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary, // Usa el color primario del tema
                contentColor = Color.White // Color de texto para contraste
            ),
            shape = RoundedCornerShape(10.dp) // Esquinas redondeadas
        ) {
            Text(text = "Enviar")
        }
    }
}


//@Preview
//@Composable
//fun MessageEditorPreview() {
//    MessageEditor { message ->
//        println("Mensaje enviado: $message")
//    }
//}
