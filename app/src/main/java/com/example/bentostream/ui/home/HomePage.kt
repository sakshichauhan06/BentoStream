package com.example.bentostream.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.bentostream.AnimeViewModel

@Composable
fun HomePage() {

    val viewModel = AnimeViewModel()
    val animes by viewModel.animes.collectAsState()

    LazyColumn {
        items(animes) { anime ->
            AnimeItem(anime)
        }
    }

}