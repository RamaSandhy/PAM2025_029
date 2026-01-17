package com.example.final_project.model

import kotlinx.serialization.Serializable

@Serializable
data class Tiket(
    val id: Int? = null,
    val namaPenumpang: String,
    val rute: String,
    val kursi: String,
    val harga: String
)