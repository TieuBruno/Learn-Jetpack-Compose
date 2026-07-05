

import com.example.jetpackcomposeplayground.data.domain.repository.UserRepository
import com.example.jetpackcomposeplayground.core.utils.ResultWrapper
import com.example.jetpackcomposeplayground.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.jetpackcomposeplayground.data.network.PostDto

class UserRepositoryImpl(private val apiService: ApiService) : UserRepository {
    override suspend fun getUser(): ResultWrapper<PostDto> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getUser()
                ResultWrapper.Success(response)
            } catch (e: Exception) {
                ResultWrapper.Error(error = e.localizedMessage)
            }
        }
    }
}