package com.example.bentostream.data

import retrofit2.http.GET

interface JikanApi {
    @GET("anime")
    suspend fun getAnimes(): AnimeResponse
}