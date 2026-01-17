package com.example.final_project.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.final_project.ui.viewmodel.TravelViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PemesananScreen(
    viewModel: TravelViewModel,
    nomorKursi: String,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    var nama by remember { mutableStateOf("") }
    var rute by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Konfirmasi Pemesanan") }) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Kursi: $nomorKursi", style = MaterialTheme.typography.headlineSmall)

            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama Penumpang") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = rute,
                onValueChange = { rute = it },
                label = { Text("Rute") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    coroutineScope.launch {
                        // Pastikan fungsi simpanTiket di ViewModel sudah benar
                        viewModel.simpanTiket(nama, rute, nomorKursi, "80k")
                        onNavigateBack()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = nama.isNotBlank() && rute.isNotBlank()
            ) {
                Text("Simpan & Konfirmasi")
            }
        }
    }
}