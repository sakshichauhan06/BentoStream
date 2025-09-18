package com.example.bentostream.data

class AnimeRepository (private val api: JikanApi){
    suspend fun getAnime(): List<AnimeData> {
        val response = api.getAnimes()
        return response.data
    }
}