package com.example.final_project

import android.app.Application
import com.example.final_project.repository.AppContainer
import com.example.final_project.repository.DefaultAppContainer
import com.google.firebase.FirebaseApp // Tambahkan import ini

class TravelApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        // LANGKAH PENTING: Inisialisasi Firebase dulu!
        FirebaseApp.initializeApp(this)

        // Baru kemudian buat containernya
        container = DefaultAppContainer()
    }
}