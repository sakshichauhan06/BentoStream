package com.example.bentostream.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bentostream.AnimeViewModel
import com.example.bentostream.AnimeViewModelFactory
import com.example.bentostream.data.AnimeRepository
import com.example.bentostream.data.RetrofitInstance



@Composable
fun HomePage() {

    val repository = AnimeRepository(RetrofitInstance.jikanApi)
    val viewModel: AnimeViewModel = viewModel(
        factory = AnimeViewModelFactory(repository)
    )
    val animeList by viewModel.animes.collectAsState()

    LazyColumn {
        items(animeList) { anime ->
            AnimeItem(anime)
        }
    }

}