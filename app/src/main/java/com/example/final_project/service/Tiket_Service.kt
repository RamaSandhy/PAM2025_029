package com.example.final_project.network

import com.example.final_project.model.Tiket
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface TiketService {
    @GET("api.php") // Sesuaikan dengan nama file php kamu
    suspend fun getAllTiket(): List<Tiket>

    @FormUrlEncoded
    @POST("api.php")
    suspend fun insertTiket(
        @Field("namaPenumpang") nama: String,
        @Field("rute") rute: String,
        @Field("kursi") kursi: String,
        @Field("harga") harga: String
    ): Response<Unit>
}