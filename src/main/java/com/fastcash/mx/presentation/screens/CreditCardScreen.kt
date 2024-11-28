package com.fastcash.mx.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.fastcash.mx.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditCardScreen(
    navController: NavHostController,
    padding: PaddingValues,
) {
    // Estados para los campos editables
    var cardNumber by remember { mutableStateOf("1234 5678 9012 3456") }
    var cardHolderName by remember { mutableStateOf("John Doe") }
    var expirationDate by remember { mutableStateOf("12/24") }
    var cvv by remember { mutableStateOf("123") }


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
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Tarjeta de crédito
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent // Fondo transparente para aplicar el degradado
                )
            ) {
                // Fondo con degradado
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF032B66), // Azul brillante
                                    Color(0xFF38599C), // Azul claro
                                    Color(0xFF072757)  // Casi blanco
                                )
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "VISA",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.align(Alignment.End)
                        )

                        Text(
                            text = cardNumber,
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = cardHolderName,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = expirationDate,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Campos editables
//            EditableField(
//                label = "Número de Tarjeta",
//                value = cardNumber,
//                onValueChange = { cardNumber = it }
//            )
//
//            EditableField(
//                label = "Nombre del Titular",
//                value = cardHolderName,
//                onValueChange = { cardHolderName = it }
//            )
//
//            EditableField(
//                label = "Fecha de Vencimiento",
//                value = expirationDate,
//                onValueChange = { expirationDate = it }
//            )
//
//            EditableField(
//                label = "CVV",
//                value = cvv,
//                onValueChange = { cvv = it }
//            )
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
                Text(text = "Añadir")
            }

        }
    }


@Composable
fun EditableField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(horizontal = 18.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White, // Color blanco cuando está enfocado
            unfocusedTextColor = Color.White, // Color blanco cuando no está enfocado
            focusedBorderColor = Color.White, // Borde blanco cuando está enfocado
            unfocusedBorderColor = Color(0xFFb5b5b5), // Borde gris cuando no está enfocado
            cursorColor = Color(0xFFEF8035), // Cursor blanco cuando está enfocado
            unfocusedLabelColor = Color(0xFFb5b5b5) // Blanco para la etiqueta cuando no está enfocado
        )

    )
}
