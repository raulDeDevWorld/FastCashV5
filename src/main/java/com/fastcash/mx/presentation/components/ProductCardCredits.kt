package com.fastcash.mx.presentation.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun ProductCardCredits(
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
//
//                    repeat(1) { index ->
//                        Icon(
//                            imageVector = Icons.Filled.Star,
//                            contentDescription = "Star",
//                            tint = if (index < rating.toInt()) Color(0xFFFF9800) else Color(
//                                0xFF8D8D8D
//                            ),
//                            modifier = Modifier.size(15.dp)
//                        )
//                    }
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                ,
                verticalArrangement = Arrangement.Center, // Centra verticalmente el contenido
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentWidth() // Hace que el contenedor ocupe solo el espacio necesario para el texto
                        .wrapContentHeight() // Evita que el texto ocupe más espacio verticalmente del necesario
                        .padding(0.dp), // Padding interno
                    text = "Pendiente",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.secondary, // Establecer color del texto
                    ),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth() // Hace que el contenedor ocupe solo el espacio necesario para el texto
                        .wrapContentHeight() // Evita que el texto ocupe más espacio verticalmente del necesario
                        .padding(0.dp), // Padding interno
                    text = "a pagar",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.secondary, // Establecer color del texto
                    ),
                    fontWeight = FontWeight.Light,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
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
                    text = "Saldo Pendite a pagar",
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
                    text = "Tiempo de prestamo",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp,
                        color = Color(0xFF383838), // Establecer color del texto
                    ),
                    fontWeight = FontWeight.Light,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
             ,
                verticalArrangement = Arrangement.Center, // Centra verticalmente el contenido
           horizontalAlignment = Alignment.End
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentWidth() // Hace que el contenedor ocupe solo el espacio necesario para el texto
                        .wrapContentHeight() // Evita que el texto ocupe más espacio verticalmente del necesario
                        .padding(0.dp), // Padding interno
                    text = "$20.500  ",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.tertiary, // Establecer color del texto
                    ),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth() // Hace que el contenedor ocupe solo el espacio necesario para el texto
                        .wrapContentHeight() // Evita que el texto ocupe más espacio verticalmente del necesario
                        .padding(0.dp), // Padding interno
                    text = "12-11-2024",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp,
                        color = Color(0xFF383838), // Establecer color del texto
                    ),
                    fontWeight = FontWeight.Light,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }


        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {



            // Información del producto
            Button(
                onClick = onButtonClick,
                modifier = Modifier.padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent, // Fondo transparente
                    contentColor = MaterialTheme.colorScheme.tertiary // Color del texto
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary), // Borde con color primario
                shape = RoundedCornerShape(8.dp) // Opcional: Esquinas redondeadas
            ) {
                Text(
                    text = "Prórroga de préstamo",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
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
                Text(text = "Pagar")
            }
        }
    }
}
