package com.example.final_project.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_project.model.Tiket
import com.example.final_project.repository.RepositoryTravel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TravelViewModel(private val repository: RepositoryTravel) : ViewModel() {
    private val _allTiket = MutableStateFlow<List<Tiket>>(emptyList())
    val allTiket: StateFlow<List<Tiket>> = _allTiket

    init { fetchTiket() }

    fun fetchTiket() {
        viewModelScope.launch {
            try { _allTiket.value = repository.getAllTiket() } catch (e: Exception) { }
        }
    }

    // TAMBAHKAN PARAMETER HARGA DI SINI
    fun simpanTiket(nama: String, rute: String, kursi: String, harga: String) {
        viewModelScope.launch {
            try {
                repository.insertTiket(
                    Tiket(
                        namaPenumpang = nama,
                        rute = rute,
                        kursi = kursi,
                        harga = harga
                    )
                )
                fetchTiket()
            } catch (e: Exception) { }
        }
    }
}