package com.example.myapplication.repository

import com.example.myapplication.api.AmiiboApi
import com.example.myapplication.api.RetrofitInstance
import com.example.myapplication.model.Root
import retrofit2.Response

class Repository {
    suspend fun getAmiibo(): Response<Root> {
        return RetrofitInstance.api.getAmiibo()
    }
}