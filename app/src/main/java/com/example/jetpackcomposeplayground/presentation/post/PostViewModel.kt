package com.example.jetpackcomposeplayground.presentation.post

import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeplayground.core.base.BaseVM
import com.example.jetpackcomposeplayground.core.utils.ResultWrapper
import com.example.jetpackcomposeplayground.data.domain.repository.PostRepository
import kotlinx.coroutines.launch

data class PostState(
    val isLoading: Boolean = false,
    val postData: String? = null,
    val error: String? = null
)

sealed class PostEvent {
    object ShowErrorToast : PostEvent()
}

class PostViewModel(private val repository: PostRepository) : BaseVM<PostState, PostEvent>(PostState()) {

    fun fetchPost() {
        setState { copy(isLoading = true, error = null) }
        viewModelScope.launch {
            when (val result = repository.getPost()) {
                is ResultWrapper.Success -> {
                    setState { copy(isLoading = false, postData = result.value) }
                }
                is ResultWrapper.Error -> {
                    setState { copy(isLoading = false, error = result.error) }
                    sendEvent(PostEvent.ShowErrorToast)
                }
                is ResultWrapper.Loading -> {
                    setState { copy(isLoading = true) }
                }
            }
        }
    }
}
