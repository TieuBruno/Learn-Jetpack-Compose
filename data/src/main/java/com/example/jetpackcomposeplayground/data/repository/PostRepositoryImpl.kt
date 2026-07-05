package com.example.jetpackcomposeplayground.data.repository

import com.example.jetpackcomposeplayground.data.domain.repository.PostRepository
import com.example.jetpackcomposeplayground.core.utils.ResultWrapper
import com.example.jetpackcomposeplayground.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepositoryImpl(private val apiService: ApiService) : PostRepository {
    override suspend fun getPost(): ResultWrapper<String> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getPost()
                ResultWrapper.Success(response.title)
            } catch (e: Exception) {
                ResultWrapper.Error(error = e.localizedMessage)
            }
        }
    }
}
