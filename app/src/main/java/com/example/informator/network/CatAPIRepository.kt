package com.example.informator.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatAPIRepository(
    private val catAPIService: CatAPIService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getRandomCat(): RandomCatResponse {
        return withContext(dispatcher) {
            catAPIService.getRandomCat()[0]
        }
    }
    suspend fun getBreeds(limit: Int, page: Int): List<CatBreed> {
        return withContext(dispatcher) {
            catAPIService.getBreeds(limit, page)
        }
    }
}