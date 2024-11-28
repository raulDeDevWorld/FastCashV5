package com.fastcash.mx.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.fastcash.mx.R
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.fastcash.mx.presentation.components.ProductCard


@SuppressLint("SuspiciousIndentation")
@Composable
fun ProductScreen(navController: NavHostController, padding: PaddingValues) {
    val products = listOf(
        "Fast Cash" to 4.8f,
        "Arrow Loan" to 1.5f,
        "Easy Cash" to 3.2f
    )



        LazyColumn(
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
            item { // Usamos `item` para incluir un solo elemento como la imagen
                Image(
                    painter = painterResource(id = R.drawable.logotipo),
                    contentDescription = "Background",
                    modifier = Modifier
                        .fillMaxWidth() // Asegura que la imagen ocupe el ancho completo
                        .height(120.dp) // Ajusta la altura según sea necesario
                        .padding(vertical = 10.dp)
                )
            }
            items(products) { product ->
                ProductCard(
                    productName = product.first,
                    rating = product.second,
                    onButtonClick = {
                        navController.navigate("checkout/${product.first}")
                    }
                )
            }
        }

}