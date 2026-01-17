package com.example.final_project.repository

import com.example.final_project.model.Tiket
import com.example.final_project.service.TiketService

interface TiketRepository {
    suspend fun getTiket(): List<Tiket>
    suspend fun insertTiket(tiket: Tiket)
}

class NetworkTiketRepository(
    private val tiketService: TiketService
) : TiketRepository {
    override suspend fun getTiket(): List<Tiket> = tiketService.getTiket()
    override suspend fun insertTiket(tiket: Tiket) = tiketService.insertTiket(tiket)
}