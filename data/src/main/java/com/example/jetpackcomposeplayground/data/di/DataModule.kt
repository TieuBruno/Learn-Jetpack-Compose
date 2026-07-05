package com.example.jetpackcomposeplayground.data.di

import com.example.jetpackcomposeplayground.data.network.RetrofitClient
import com.example.jetpackcomposeplayground.data.repository.PostRepositoryImpl
import com.example.jetpackcomposeplayground.data.domain.repository.PostRepository
import com.example.jetpackcomposeplayground.data.domain.repository.UserRepository
import org.koin.dsl.module
import UserRepositoryImpl

val dataModule = module {
    single { RetrofitClient.retrofit.create(com.example.jetpackcomposeplayground.data.network.ApiService::class.java) }
    single<PostRepository> { PostRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}
