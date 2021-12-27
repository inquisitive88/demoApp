package  com.test.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkConfigurationImpl @Inject constructor() : NetworkConfiguration {

    companion object {
        private const val BASE_URL = "https://phpstack-473415-1981510.cloudwaysapps.com/api/"
    }

    override fun getBaseUrl(): String {
        return BASE_URL
    }


}