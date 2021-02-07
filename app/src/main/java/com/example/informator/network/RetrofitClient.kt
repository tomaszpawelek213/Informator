package com.example.informator.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitClient {

    fun getCatAPIService(): CatAPIService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val okHttpClient = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        return retrofit.create(CatAPIService::class.java)
    }
}