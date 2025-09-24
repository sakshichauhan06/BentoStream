package com.example.bentostream.data

import android.content.Context
import androidx.lifecycle.LiveData

class AnimeRepository (private val api: JikanApi){


    suspend fun getAnimes(): List<AnimeData> {
        val response = api.getAnimes()
        return response.data
    }
}