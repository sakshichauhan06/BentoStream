package com.example.bentostream.ui.home

import android.R.attr.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bentostream.AnimeViewModel
import com.example.bentostream.AnimeViewModelFactory
import com.example.bentostream.data.AnimeRepository
import com.example.bentostream.data.RetrofitInstance
import com.example.bentostream.ui.AppHeader


@Composable
fun HomePage(navController: NavController) {

    val repository = AnimeRepository(RetrofitInstance.jikanApi)
    val viewModel: AnimeViewModel = viewModel(
        factory = AnimeViewModelFactory(repository)
    )
    val animeList by viewModel.animes.collectAsState()

    Scaffold(
        topBar = { AppHeader() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(animeList) { anime ->
                AnimeItem(anime) { animeId ->
                    navController.navigate("detail/$animeId")
                }
            }
        }
    }

}