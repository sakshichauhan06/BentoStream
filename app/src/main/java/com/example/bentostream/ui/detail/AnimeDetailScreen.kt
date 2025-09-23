package com.example.bentostream.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
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
import androidx.navigation.compose.rememberNavController
import com.example.bentostream.AnimeViewModel
import com.example.bentostream.AnimeViewModelFactory
import com.example.bentostream.data.AnimeData
import com.example.bentostream.data.AnimeRepository
import com.example.bentostream.data.Genre
import com.example.bentostream.data.Images
import com.example.bentostream.data.Jpg
import com.example.bentostream.data.RetrofitInstance
import com.example.bentostream.data.Trailer
import com.example.bentostream.data.TrailerImages
import com.example.bentostream.ui.AppHeader
import com.example.bentostream.ui.home.AnimeItem

@Composable
fun AnimeDetailScreen(
    animeId: Int,
    navController: NavController,


) {
    val repository = AnimeRepository(RetrofitInstance.jikanApi)
    val viewModel: AnimeViewModel = viewModel(
        factory = AnimeViewModelFactory(repository)
    )

    // Collect anime list and find the one with the matching ID
    val animeList by viewModel.animes.collectAsState()
    val anime = animeList.find { it.mal_id == animeId }

    Scaffold (
        topBar = { AppHeader() }
    ) { paddingValues ->
        anime?.let {
            Column(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
            ) {
                // Basic info about Anime
                AnimeItemDetail(anime = it) // no click inside detail

                // Synopsis
                SynopsisSection(anime)

                // Trailer Section
                if (!it.trailer.youtube_id.isNullOrEmpty()) {
                    TrailerSection(trailerUrl = "https://www.youtube.com/watch?v=${it.trailer.youtube_id}")
                }
            }
        } ?: run {
            Text("Loading...")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun AnimeDetailScreenPreview() {
    // Fake anime data for preview
    val fakeAnime = AnimeData(
        mal_id = 1,
        title = "Naruto",
        title_english = "Naruto",
        title_japanese = "ナルト",
        episodes = 220,
        score = 8.2,
        scored_by = 1200000,
        images = Images(
            jpg = Jpg("https://cdn.myanimelist.net/images/anime/13/17405.jpg")
        ),
        genres = listOf(
            Genre(1, "Action"),
            Genre(2, "Adventure")
        ),
        synopsis = "Naruto Uzumaki, a hyperactive ninja, seeks recognition and dreams of becoming Hokage.",
        trailer = Trailer(
            youtube_id = "QczGoCmX-pI", // Example trailer
            url = "https://www.youtube.com/watch?v=QczGoCmX-pI",
            embed_url = "https://www.youtube.com/embed/QczGoCmX-pI",
            images = TrailerImages(
                image_url = "https://img.youtube.com/vi/QczGoCmX-pI/0.jpg",
                small_image_url = null,
                medium_image_url = null,
                large_image_url = null,
                maximum_image_url = null
            )
        )
    )

    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AnimeItem(anime = fakeAnime, onItemClick = {})

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

        TrailerSection(trailerUrl = "https://www.youtube.com/watch?v=${fakeAnime.trailer.youtube_id}")
    }
}