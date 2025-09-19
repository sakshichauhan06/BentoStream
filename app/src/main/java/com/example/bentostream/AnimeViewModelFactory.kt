package com.example.bentostream

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bentostream.data.AnimeRepository

class AnimeViewModelFactory(
    private val repository: AnimeRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimeViewModel::class.java)) {
            return AnimeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}