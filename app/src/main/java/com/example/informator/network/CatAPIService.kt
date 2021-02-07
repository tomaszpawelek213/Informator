package com.example.informator.network

import retrofit2.http.GET
import retrofit2.http.Query

interface CatAPIService {
    @GET("images/search")
    suspend fun getRandomCat(): List<RandomCatResponse>

    @GET("breeds")
    suspend fun getBreeds(
            @Query("limit") limit: Int,
            @Query("page") page: Int
    ): List<CatBreed>

//    @GET("/images/search")
}

data class RandomCatResponse(
    val url: String,
    val width: Int,
    val height: Int,
    val id: String,
    val breeds: List<CatBreed>
)

data class CatBreed(
   val name: String,
   val weight: CatWeight
)
data class CatWeight(
    val imperial: String
)

