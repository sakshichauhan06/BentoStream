package com.example.bentostream.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bentostream.AnimeViewModel
import com.example.bentostream.AnimeViewModelFactory
import com.example.bentostream.data.AnimeRepository
import com.example.bentostream.data.RetrofitInstance
import com.example.bentostream.ui.home.AnimeItem
import com.example.bentostream.ui.detail.TrailerSection
import java.time.format.TextStyle

@Composable
fun AnimeDetailScreen(
    animeId: Int,
    navController: NavController
) {
    val repository = AnimeRepository(RetrofitInstance.jikanApi)
    val viewModel: AnimeViewModel = viewModel(
        factory = AnimeViewModelFactory(repository)
    )

    // Collect anime list and find the one with the matching ID
    val animeList by viewModel.animes.collectAsState()
    val anime = animeList.find { it.mal_id == animeId }

    anime?.let {
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Reuse your AnimeItem
            AnimeItem(anime = it, onItemClick = { }) // no click inside detail

            // Synopsis
            Text(
                text = "Synopsis:",
//                style = TextStyle(
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold
//                ),
                modifier = Modifier
                    .padding(8.dp)
            )
            Text(
                text = it.synopsis,
//                style = TextStyle(
//                    fontSize = 15.sp,
//                ),
                modifier = androidx.compose.ui.Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )

            // Trailer Section
            if (!it.trailer.youtube_id.isNullOrEmpty()) {
                TrailerSection(trailerUrl = "https://www.youtube.com/watch?v=${it.trailer.youtube_id}")
            }
        }
    } ?: run {
        Text("Loading...")
    }
}
