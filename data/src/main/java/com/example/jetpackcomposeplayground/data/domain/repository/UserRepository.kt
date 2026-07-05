package com.example.jetpackcomposeplayground.data.domain.repository

import com.example.jetpackcomposeplayground.core.utils.ResultWrapper
import com.example.jetpackcomposeplayground.data.network.PostDto

interface UserRepository {
    suspend fun getUser(): ResultWrapper<PostDto>
}