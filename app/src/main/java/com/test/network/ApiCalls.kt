package com.test.network


import com.test.home.model.ResponseMostViewed
import retrofit2.Call
import retrofit2.http.*

interface ApiCalls {


    @GET("svc/mostpopular/v2/viewed/1.json")
    suspend fun getMostPopular(
        @Query("api-key") apikey: String
    ): ResponseMostViewed


}