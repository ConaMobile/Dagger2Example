package com.conamobile.dagger2example.network

import com.conamobile.dagger2example.models.UserData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<UserData>>
}