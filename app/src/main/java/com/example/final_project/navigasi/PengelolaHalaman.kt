package com.example.final_project.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.final_project.ui.view.PemesananScreen
import com.example.final_project.ui.viewmodel.TravelViewModel

@Composable
fun PengelolaHalaman(
    viewModel: TravelViewModel,
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home", // Pastikan rute "home" ada di bawah
        modifier = modifier
    ) {
        // Rute Home (Contoh jika kamu punya HomeScreen)
        composable("home") {
            // Ganti dengan HomeScreen kamu atau tombol yang navigasi ke "pesan/A1"
        }

        // Rute Pemesanan yang tadi Error
        composable(
            route = "pesan/{kursi}",
            arguments = listOf(navArgument("kursi") { type = NavType.StringType })
        ) { backStack ->
            val kursi = backStack.arguments?.getString("kursi") ?: "A1"

            PemesananScreen(
                viewModel = viewModel, // Kirim viewModel utuh
                nomorKursi = kursi,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}