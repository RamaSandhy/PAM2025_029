package com.example.final_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.final_project.navigasi.PengelolaHalaman
import com.example.final_project.ui.theme.Final_ProjectTheme
import com.example.final_project.ui.viewmodel.TravelViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Final_ProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 1. Ambil container aplikasi
                    val app = application as TravelApplication
                    val repository = app.container.tiketRepository

                    // 2. Inisialisasi ViewModel menggunakan Factory
                    val mViewModel: TravelViewModel = viewModel(
                        factory = TravelViewModel.Factory(repository)
                    )

                    // 3. Panggil PengelolaHalaman (BUKAN PemesananScreen langsung)
                    // Ini akan mengatur alur dari Home -> Pemesanan
                    PengelolaHalaman(viewModel = mViewModel)
                }
            }
        }
    }
}