package com.example.final_project.repository

import com.example.final_project.model.Tiket

interface AppContainer {
    val tiketRepository: TiketRepository
}

class DefaultAppContainer : AppContainer {
    // Kita pindah ke Firebase, jadi tidak butuh BaseURL atau Retrofit lagi
    override val tiketRepository: TiketRepository by lazy {
        FirebaseTiketRepository()
    }
}