package com.fastcash.mx.presentation.screens

import androidx.compose.foundation.lazy.items
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.fastcash.mx.R
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import com.fastcash.mx.presentation.components.ProductCard
import com.fastcash.mx.presentation.components.ProductCardCredits


@SuppressLint("SuspiciousIndentation")
@Composable
fun CreditsScreen(navController: NavHostController, padding: PaddingValues) {
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
        items(products) { product ->
            ProductCardCredits(
                productName = product.first,
                rating = product.second,
                onButtonClick = {
                    navController.navigate("checkout/${product.first}")
                }
            )
        }
    }

}