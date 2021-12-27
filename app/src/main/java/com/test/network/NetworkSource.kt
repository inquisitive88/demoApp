package  com.test.network


import com.test.home.model.ResponseMostViewed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject



class HomeData @Inject constructor(private val api: ApiCalls) {


    suspend fun GetMostPopularProcess(
        key: String
    ): ResponseMostViewed? = withContext(Dispatchers.IO) {
        val data =
            api.getMostPopular(key)
        data
    }

}


