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
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showBackground = true)
@Composable
fun AnimeDetailScreenPreview() {
    // Fake anime data for preview
    val fakeAnime = com.example.bentostream.data.AnimeData(
        mal_id = 1,
        title = "Naruto",
        title_english = "Naruto",
        title_japanese = "ナルト",
        episodes = 220,
        score = 8.2,
        scored_by = 1200000,
        images = com.example.bentostream.data.Images(
            jpg = com.example.bentostream.data.Jpg("https://cdn.myanimelist.net/images/anime/13/17405.jpg")
        ),
        genres = listOf(
            com.example.bentostream.data.Genre(1, "Action"),
            com.example.bentostream.data.Genre(2, "Adventure")
        ),
        synopsis = "Naruto Uzumaki, a hyperactive ninja, seeks recognition and dreams of becoming Hokage.",
        trailer = com.example.bentostream.data.Trailer(
            youtube_id = "QczGoCmX-pI", // Example trailer
            url = "https://www.youtube.com/watch?v=QczGoCmX-pI",
            embed_url = "https://www.youtube.com/embed/QczGoCmX-pI"
        )
    )

    // Mock NavController (for preview only)
    val navController = androidx.navigation.compose.rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Show AnimeItem
        com.example.bentostream.ui.home.AnimeItem(anime = fakeAnime, onItemClick = {})

        // Synopsis
        Text(
            text = "Synopsis:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = fakeAnime.synopsis,
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )

        // Trailer Section
        TrailerSection(trailerUrl = "https://www.youtube.com/watch?v=${fakeAnime.trailer.youtube_id}")
    }
}

