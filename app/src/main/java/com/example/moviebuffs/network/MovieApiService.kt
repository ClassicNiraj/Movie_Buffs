package com.example.moviebuffs.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://kareemy.github.io"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object MovieApi{
    val retrofitService : MovieApiService by lazy{
        retrofit.create(MovieApiService::class.java)
    }
}
interface MovieApiService {
    @GET("MovieBuffs/movies.json")
    suspend fun getMovies(): String
}