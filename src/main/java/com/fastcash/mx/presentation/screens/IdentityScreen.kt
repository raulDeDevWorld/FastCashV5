package com.fastcash.mx.presentation.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
@Composable
fun IdentityScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Gray)
    ) {
        Text("Cédula de Identidad", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        CameraCaptureComponent(label = "Fotografía de Frente de Cédula")
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Número de Cédula de Identidad") }, modifier = Modifier.fillMaxWidth())
        CameraCaptureComponent(label = "Fotografía de Rostro")
        Button(onClick = { navController.navigate("loanInfo") }, modifier = Modifier.align(Alignment.End)) {
            Text("Siguiente")
        }
    }
}
@Composable
fun CameraCaptureComponent(label: String) {
    Text(label, modifier = Modifier.padding(vertical = 8.dp))
    // Aquí se implementaría una vista personalizada para la cámara usando CameraX.
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Text("Vista de Cámara")
    }
}
