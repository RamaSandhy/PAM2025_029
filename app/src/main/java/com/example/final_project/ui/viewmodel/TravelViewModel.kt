package com.example.final_project.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.final_project.model.Tiket
import com.example.final_project.repository.TiketRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TravelViewModel(private val repository: TiketRepository) : ViewModel() {

    private val _allTiket = MutableStateFlow<List<Tiket>>(emptyList())
    val allTiket: StateFlow<List<Tiket>> = _allTiket

    fun simpanTiket(nama: String, rute: String, kursi: String, harga: String) {
        viewModelScope.launch {
            try {
                // Pastikan parameter id diisi string kosong dulu
                val tiketBaru = Tiket("", nama, rute, kursi, harga)
                repository.simpanTiket(tiketBaru)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        fun Factory(repository: TiketRepository): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return TravelViewModel(repository) as T
            }
        }
    }
}