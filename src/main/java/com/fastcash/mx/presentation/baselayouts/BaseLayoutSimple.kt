


package com.fastcash.mx.presentation.baselayouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fastcash.mx.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import com.fastcash.mx.presentation.components.BottomNavigationBar





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseLayoutSimple(
    navController: NavHostController,
    title: String = "",
    showLogo: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(Color(0xFFFFFFFF))
                    .height(25.dp), // Personaliza la altura aquí
                title = { Text(title, color = Color(0xFFFFFFFF)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                actions = {
                    if (showLogo) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.padding(top = 2.dp).background(Color(0x00000000)) // Ajusta el espaciado
                        ) {

                            IconButton(
                                onClick = { /* Acción si se requiere */ },
                                modifier = Modifier.size(15.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.atencion),
                                    contentDescription = "Logo de la App",
                                    modifier = Modifier.size(15.dp) // Tamaño del logo
                                )
                            }

                            Text(
                                text = "Atención al cliente", // Texto pegado a la imagen
                                color = Color(0xFFFFFFFF), // Color del texto
                                style = MaterialTheme.typography.bodyMedium, // Estilo del texto
                                modifier = Modifier.padding(start = 8.dp) // Espaciado entre imagen y texto
                            )

                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    navigationIconContentColor = Color(0xFFFFFFFF),
                    titleContentColor = Color(0xFFFFFFFF),
                    actionIconContentColor = Color(0xFFFFFFFF)
                )
            )

        },


        content = content
    )
}


