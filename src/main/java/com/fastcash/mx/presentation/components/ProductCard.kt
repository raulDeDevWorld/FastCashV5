package com.fastcash.mx.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fastcash.mx.R

@Composable
fun ProductCard(
    productName: String,
    rating: Float,
    onButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD9D9D9) // Color de fondo personalizado
        )
//        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen del producto
            Image(
                painter = painterResource(id = R.drawable.logo), // Reemplaza con tu imagen
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp)),
//                    .background(), // Color de fondo si no hay imagen
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Información del producto
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center, // Centra verticalmente el contenido
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentWidth() // Hace que el contenedor ocupe solo el espacio necesario para el texto
                        .wrapContentHeight() // Evita que el texto ocupe más espacio verticalmente del necesario
                        .padding(0.dp), // Padding interno
                    text = productName,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 18.sp,
                        color = Color.Black, // Establecer color del texto
                    ),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier
                        .wrapContentWidth() // Hace que la fila ocupe solo el ancho necesario para las estrellas
                ) {



                    Text(
                        modifier = Modifier
                            .wrapContentWidth() // Hace que el contenedor ocupe solo el espacio necesario para el texto
                            .wrapContentHeight() // Evita que el texto ocupe más espacio verticalmente del necesario
                            .padding(0.dp), // Padding interno
                        text = "4.9",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.primary, // Establecer color del texto
                        ),
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    repeat(1) { index ->
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Star",
                            tint = if (index < rating.toInt()) Color(0xFFFF9800) else Color(
                                0xFF8D8D8D
                            ),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = onButtonClick,
                modifier = Modifier.padding(top=8.dp), // Espaciado adicional si lo necesitas
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary, // Usa el color primario del tema
                    contentColor = androidx.compose.ui.graphics.Color.White // Color de texto para contraste
                ),
            ) {
                Text(text = "Solicitar")
            }
        }

        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {



            // Información del producto
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center, // Centra verticalmente el contenido
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentWidth() // Hace que el contenedor ocupe solo el espacio necesario para el texto
                        .wrapContentHeight() // Evita que el texto ocupe más espacio verticalmente del necesario
                        .padding(0.dp), // Padding interno
                    text = "Prestamo maximo",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 14.sp,
                        color = Color.Black, // Establecer color del texto
                    ),
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth() // Hace que el contenedor ocupe solo el espacio necesario para el texto
                        .wrapContentHeight() // Evita que el texto ocupe más espacio verticalmente del necesario
                        .padding(0.dp), // Padding interno
                    text = "Interes diario 1.5%",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp,
                        color = Color(0xFF303030), // Establecer color del texto
                    ),
                    fontWeight = FontWeight.Light,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                modifier = Modifier
                    .wrapContentWidth() // Hace que el contenedor ocupe solo el espacio necesario para el texto
                    .wrapContentHeight() // Evita que el texto ocupe más espacio verticalmente del necesario
                    .padding(0.dp), // Padding interno
                text = "$20.500 ",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.tertiary, // Establecer color del texto
                ),
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
