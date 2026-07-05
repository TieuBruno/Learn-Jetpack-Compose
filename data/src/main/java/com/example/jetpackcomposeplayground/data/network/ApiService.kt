package com.example.jetpackcomposeplayground.data.network

import retrofit2.http.GET

interface ApiService {
    @GET("posts/1")
    suspend fun getPost(): PostDto

    @GET("posts/1")
    suspend fun getUser(): PostDto
}
