package com.fastcash.mx.presentation.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun EmergencyContactsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.LightGray)
    ) {
        Text("Contactos de Emergencia", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        (1..2).forEach { index ->
            Text("Contacto de Emergencia $index", fontWeight = FontWeight.Bold)
            OutlinedTextField(value = "", onValueChange = {}, label = { Text("Relación") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = "", onValueChange = {}, label = { Text("Número de Teléfono") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = "", onValueChange = {}, label = { Text("Nombres") }, modifier = Modifier.fillMaxWidth())
        }
        Button(onClick = { navController.navigate("identity") }, modifier = Modifier.align(Alignment.End)) {
            Text("Siguiente")
        }
    }
}
