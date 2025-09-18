package com.example.bentostream

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bentostream.data.AnimeData
import com.example.bentostream.data.AnimeRepository
import com.example.bentostream.data.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AnimeViewModel(private val repository: AnimeRepository): ViewModel() {
    private val _animes = MutableStateFlow<List<AnimeData>>(emptyList())

    val animes: StateFlow<List<AnimeData>> = _animes

    init {
        fetchAnimes()
    }

    fun fetchAnimes() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.jikanApi.getAnimes()
                _animes.value = response.data
            } catch (e: Exception) {
                println("Error fetching animes: ${e.message}")
            }
        }
    }
}