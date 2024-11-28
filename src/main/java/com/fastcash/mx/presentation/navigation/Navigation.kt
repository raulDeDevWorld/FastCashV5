package com.fastcash.mx.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fastcash.mx.data.repository.AuthRepository
import com.fastcash.mx.presentation.baselayouts.BaseLayout
import com.fastcash.mx.presentation.baselayouts.BaseLayoutSimple
import com.fastcash.mx.presentation.screens.AboutScreen
import com.fastcash.mx.presentation.screens.AccountScreen
import com.fastcash.mx.presentation.screens.CreditCardScreen
import com.fastcash.mx.presentation.screens.CreditsScreen
import com.fastcash.mx.presentation.screens.EmergencyContactsScreen
import com.fastcash.mx.presentation.screens.FeedbackScreen
import com.fastcash.mx.presentation.screens.LoginScreen
import com.fastcash.mx.presentation.screens.SignupScreen
import com.fastcash.mx.presentation.screens.HomeScreen
import com.fastcash.mx.presentation.screens.IdentityScreen
import com.fastcash.mx.presentation.screens.LoanInfoScreen
import com.fastcash.mx.presentation.screens.PersonalInfoScreen
import com.fastcash.mx.presentation.screens.PrivacyPolicyScreen
import com.fastcash.mx.presentation.screens.ProductScreen
import com.fastcash.mx.presentation.viewmodels.AuthViewModel

@Composable
fun SuccessScreen(userId: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "¡Registro exitoso! Tu ID de usuario es: $userId")
    }
}


@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    authRepository: AuthRepository // Pasar el repositorio desde la actividad principal
) {
    NavHost(
        navController = navController,
        startDestination = "personalInfo"
    ) {
        composable("signup") {
            val viewModel = remember { AuthViewModel(authRepository) }
            SignupScreen(
                authViewModel = viewModel,
                onSignupSuccess = { userId ->
                    navController.navigate("success/$userId")
                },
                navController = navController, // Pasar navController

            )
        }
        composable(
            route = "success/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: ""
            SuccessScreen(userId = userId)
        }
        composable("products") {
            BaseLayout(navController) { padding ->
                ProductScreen(
                    navController = navController,
                    padding = padding // Asegúrate de pasar el padding aquí
                )
            }
        }
        composable("credits") {
            BaseLayout(navController) { padding ->
                CreditsScreen(
                    navController = navController,
                    padding = padding // Asegúrate de pasar el padding aquí
                )
            }
        }
        composable("privacy_policy") {
            BaseLayoutSimple(navController) { padding ->
                PrivacyPolicyScreen(
                    navController = navController, // Pasar navController
                    padding = padding // Asegúrate de pasar el padding aquí
                )
            }
        }
        composable("feedback") {
            BaseLayoutSimple(navController) { padding ->
                FeedbackScreen(
                    navController = navController, // Pasar navController
                    padding = padding, // Asegúrate de pasar el padding aquí
                    onSendMessage = {  }

                )
            }
        }
        composable("about") {
            BaseLayoutSimple(navController) { padding ->
                AboutScreen(
                    navController = navController, // Pasar navController
                    padding = padding // Asegúrate de pasar el padding aquí
                )
            }
        }
        composable("creditCard") {
            BaseLayoutSimple(navController) { padding ->
                CreditCardScreen(
                    navController = navController, // Pasar navController
                    padding = padding // Asegúrate de pasar el padding aquí
                )
            }
        }
        composable("history") {
            BaseLayoutSimple(navController) { padding ->
                PrivacyPolicyScreen(
                    navController = navController, // Pasar navController
                    padding = padding // Asegúrate de pasar el padding aquí
                )
            }
        }
        composable("account") {
            BaseLayout(navController) { padding ->
                AccountScreen(
                    padding = padding, // Asegúrate de pasar el padding aquí
                    onNavigateToQuejas = { navController.navigate("feedback") },
                    onNavigateToNosotros = { navController.navigate("about") },
                    onNavigateToPolitica = { navController.navigate("privacy_policy") },
                    onNavigateToTarjeta = { navController.navigate("creditCard") },
                    onNavigateToHistorial = { navController.navigate("historial_screen") },

                )
            }
            composable("personalInfo") { PersonalInfoScreen(navController) }
            composable("emergencyContacts") { EmergencyContactsScreen(navController) }
            composable("identity") { IdentityScreen(navController) }
            composable("loanInfo") { LoanInfoScreen(navController) }
        }
//
    }
}


