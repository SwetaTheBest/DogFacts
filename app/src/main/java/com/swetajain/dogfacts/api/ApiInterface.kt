package com.swetajain.dogfacts.api

import com.swetajain.dogfacts.models.Fact
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    companion object {
        val mServices: ApiInterface by lazy {
            RetrofitInstance.getRetrofitInstance()
                .create(ApiInterface::class.java)
        }
    }


    // https://dog-facts-api.herokuapp.com/api/v1/resources/dogs?number=10
    @GET("dogs")
    suspend fun getFacts(
        @Query("number") number: Int
    ): Response<List<Fact>>
}
