package com.example.myapplication.api

import com.example.myapplication.model.Root
import retrofit2.Response
import retrofit2.http.GET

interface AmiiboApi {

    @GET("api/amiibo/")
    suspend fun getAmiibo(): Response<Root>
}