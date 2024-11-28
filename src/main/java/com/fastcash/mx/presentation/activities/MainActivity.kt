package com.fastcash.mx.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.fastcash.mx.R
import com.fastcash.mx.data.api.RetrofitInstance
import com.fastcash.mx.data.repository.AuthRepository
import com.fastcash.mx.presentation.navigation.AppNavHost
import com.fastcash.mx.ui.theme.FastCashTheme







class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)






        // Crear instancia del repositorio manualmente
        val apiService = RetrofitInstance.apiService // Instancia de ApiService
        val authRepository = AuthRepository(apiService)

        setContent {
            FastCashTheme(dynamicColor = false) {
                // Configurar la navegación
                val navController = rememberNavController()

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp),
                    contentAlignment = Alignment.Center
                ) {





                    // Imagen de fondo
//                    Image(
//                        painter = painterResource(id = R.drawable.bg2), // ID de la imagen
//                        contentDescription = "Background",
//                        modifier = Modifier
//                            .fillMaxSize(),
//                        contentScale = ContentScale.Crop // Imagen como fondo
//                    )

                    // Capa de degradado encima de la imagen
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xb3010714),
                                        Color(0xFF000000)
                                    ) // Degradado de verde a verde
                                )
                            )
                    )

                    // Llamada al navController con el repositorio
                    AppNavHost(navController = navController, authRepository = authRepository)
                }
            }
        }
    }
}





