package com.example.jetpackcomposeplayground.data.domain.repository

import com.example.jetpackcomposeplayground.core.utils.ResultWrapper

interface PostRepository {
    suspend fun getPost(): ResultWrapper<String>
}
