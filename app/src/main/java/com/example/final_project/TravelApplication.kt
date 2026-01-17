package com.example.final_project // SESUAIKAN dengan nama package kamu jika berbeda

import android.app.Application
import com.example.final_project.repository.AppContainer
import com.example.final_project.repository.DefaultAppContainer

class TravelApplication : Application() {
    /** AppContainer instance used by the rest of the classes to obtain dependencies */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}