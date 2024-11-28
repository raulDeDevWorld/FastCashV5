package com.fastcash.mx.presentation.screens


import android.R.attr.singleLine
import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fastcash.mx.R
import com.fastcash.mx.presentation.viewmodels.AuthViewModel
import com.fastcash.mx.presentation.viewmodels.SignupState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    authViewModel: AuthViewModel,
    onSignupSuccess: (String) -> Unit, // Navegación al siguiente paso tras éxito
    navController: NavHostController // Recibe el navController

) {
    val signupState by authViewModel.signupState.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nombreCompleto by remember { mutableStateOf("") }

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



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = R.drawable.logo), // Reemplaza con tu recurso de imagen
            contentDescription = "Imagen de ejemplo", // Descripción para accesibilidad
            modifier = Modifier
                .width(150.dp)
                .height(150.dp), // Ajusta la altura de la imagen
            contentScale = ContentScale.Crop // Escala la imagen para que llene el espacio recortándola
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Crear cuenta",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 24.sp, // Aumenta el tamaño de la fuente a 24sp
                color = Color.White // Establece el color del texto a blanco
            ),
//            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

//            CheckNetworkConnection()
//            CheckNetworkConnection()
        // Campo de nombre
        OutlinedTextField(
            value = nombreCompleto,
            onValueChange = { nombreCompleto = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 10.dp), // Margen en la parte inferior

            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                // Colores para el texto
                focusedTextColor = Color.White, // Color blanco cuando está enfocado
                unfocusedTextColor = Color.White, // Color blanco cuando no está enfocado

                // Colores del borde
                focusedBorderColor = Color.White, // Borde blanco cuando está enfocado
                unfocusedBorderColor = Color(0xFFb5b5b5), // Borde gris cuando no está enfocado

                // Colores del contenedor
//                focusedContainerColor = Color(0xFF333333), // Fondo oscuro cuando está enfocado
//                unfocusedContainerColor = Color(0xFF444444), // Fondo oscuro cuando no está enfocado
//                disabledContainerColor = Color(0xFF888888), // Fondo cuando está deshabilitado
//                errorContainerColor = Color(0xFFCC0000), // Fondo rojo cuando está en error

                // Colores del cursor
                cursorColor = Color.White, // Cursor blanco cuando está enfocado

//                focusedLabelColor = Color.White, // Gris para la etiqueta cuando está enfocado
                unfocusedLabelColor = Color(0xFFb5b5b5) // Blanco para la etiqueta cuando no está enfocado

            )
        )


        // Campo de correo electrónico
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 10.dp), // Margen en la parte inferior

            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White, // Color blanco cuando está enfocado
                unfocusedTextColor = Color.White, // Color blanco cuando no está enfocado
                focusedBorderColor = Color.White, // Borde blanco cuando está enfocado
                unfocusedBorderColor = Color(0xFFb5b5b5), // Borde gris cuando no está enfocado
                cursorColor = Color(0xFFEF8035), // Cursor blanco cuando está enfocado
                unfocusedLabelColor = Color(0xFFb5b5b5) // Blanco para la etiqueta cuando no está enfocado
            )
        )

        // Campo de contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 10.dp) // Margen en la parte inferior
                .defaultMinSize(minHeight = 40.dp), // Ajusta la altura mínima del TextField


            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White, // Color blanco cuando está enfocado
                unfocusedTextColor = Color.White, // Color blanco cuando no está enfocado
                focusedBorderColor = Color.White, // Borde blanco cuando está enfocado
                unfocusedBorderColor = Color(0xFFb5b5b5), // Borde gris cuando no está enfocado
                cursorColor = Color.White, // Cursor blanco cuando está enfocado
                unfocusedLabelColor = Color(0xFFb5b5b5) // Blanco para la etiqueta cuando no está enfocado
            )
        )


        // Botón de registro
        Button(
            onClick = { authViewModel.signup(email, password, nombreCompleto) },
            modifier = Modifier.fillMaxWidth().padding(top= 10.dp).height(55.dp) // Ajusta la altura aquí
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary, // Usa el color primario del tema
                contentColor = Color.White // Color de texto para contraste
            ),
            shape = RoundedCornerShape(10.dp) // Esquinas redondeadas
        ) {
            Text(text = "Registrarse")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = annotatedString2,
            modifier = Modifier.clickable {
                navController.navigate("login") // Navegar a login al hacer clic
            },
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.secondary // Establecer color del texto
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = annotatedString,
            modifier = Modifier.clickable {
                annotatedString.getStringAnnotations(0, annotatedString.length).firstOrNull()?.let {
                    if (it.tag == "privacy_policy") {
                        navController.navigate("privacy_policy") // Navegar a Privacy Policy
                    } else {
                        navController.navigate("products") // Navegar a Terms of Use
                    }
                }
            },
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 14.sp, // Tamaño adecuado para leer en pantalla
                color = MaterialTheme.colorScheme.primary // Establece el color del texto al color primario del tema
            ),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Indicador de carga o mensajes de estado
        when (signupState) {
            is SignupState.Loading -> {
                CircularProgressIndicator()
            }

            is SignupState.Success -> {
                onSignupSuccess((signupState as SignupState.Success).userId)
            }

            is SignupState.Error -> {
                Text(
                    text = (signupState as SignupState.Error).message,
                    color = MaterialTheme.colorScheme.error
                )
            }

            else -> {}
        }
    }


}


//@SuppressLint("ServiceCast")
//@Composable
//fun CheckNetworkConnection() {
//    val context = LocalContext.current
//    val connectivityManager =
//        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    val activeNetwork = connectivityManager.activeNetworkInfo
//    val isConnected = activeNetwork?.isConnectedOrConnecting == true
//
//    // Mostrar mensaje según el estado de la conexión
//    if (isConnected) {
//        Text("Conectado a Internet")
//    } else {
//        Text("Sin conexión a Internet")
//    }
//}