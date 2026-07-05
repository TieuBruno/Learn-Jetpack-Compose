package com.example.jetpackcomposeplayground.core.di

import org.koin.dsl.module

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.jetpackcomposeplayground.presentation.post.PostViewModel

val appModule = module {
    viewModel { PostViewModel(get()) }
}
