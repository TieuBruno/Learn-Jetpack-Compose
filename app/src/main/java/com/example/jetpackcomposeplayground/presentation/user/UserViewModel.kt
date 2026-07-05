package com.example.jetpackcomposeplayground.presentation.user

import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeplayground.core.base.BaseVM
import com.example.jetpackcomposeplayground.core.utils.ResultWrapper
import com.example.jetpackcomposeplayground.data.domain.repository.UserRepository
import com.example.jetpackcomposeplayground.data.network.PostDto
import kotlinx.coroutines.launch

data class UserState(
    val isLoading: Boolean = false,
    val userData: PostDto? = null,
    val error: String? = null
)

sealed class UserEvent {
    object ShowErrorToast : UserEvent()
}

class UserViewModel(private val repository: UserRepository) : BaseVM<UserState, UserEvent>(UserState()) {
    fun fetchUser() {
        setState { copy(isLoading = true, error = null) }
        viewModelScope.launch {
            when (val result = repository.getUser()) {
                is ResultWrapper.Success -> {
                    setState { copy(isLoading = false, userData = result.value) }
                }
                is ResultWrapper.Error -> {
                    setState { copy(isLoading = false, error = result.error) }
                    sendEvent(UserEvent.ShowErrorToast)
                }
                is ResultWrapper.Loading -> {
                    setState { copy(isLoading = true) }
                }
            }
        }
    }
}