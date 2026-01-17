package com.example.final_project.repository

import com.example.final_project.model.Tiket
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

interface TiketRepository {
    suspend fun getTiket(): List<Tiket>
    suspend fun simpanTiket(tiket: Tiket)
}

class FirebaseTiketRepository : TiketRepository {
    // GANTI baris di bawah ini dengan URL dari Firebase Console kamu
    private val database = FirebaseDatabase
        .getInstance("https://travelkita-6e9b6-default-rtdb.asia-southeast1.firebasedatabase.app/\n" +
                ":") // <--- COPY URL DARI FIREBASE CONSOLE
        .getReference("tiket")

    override suspend fun getTiket(): List<Tiket> {
        return try {
            val snapshot = database.get().await()
            snapshot.children.mapNotNull { it.getValue(Tiket::class.java) }
        } catch (e: Exception) {
            e.printStackTrace() // Tambahkan ini untuk lihat error di logcat jika gagal tarik data
            emptyList()
        }
    }

    override suspend fun simpanTiket(tiket: Tiket) {
        val key = database.push().key ?: return
        database.child(key).setValue(tiket.copy(id = key)).await()
    }
}