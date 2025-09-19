package com.example.bentostream.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.bentostream.data.AnimeData
import com.example.bentostream.data.Genre
import com.example.bentostream.data.Images
import com.example.bentostream.data.Jpg


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AnimeItem(anime: AnimeData) {
    Column {
        GlideImage(
            model = anime.images.jpg.image_url,
            contentDescription = anime.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = anime.title)
        Text(text = "Genres: ${anime.genres.joinToString { it.name }}")
        Text(text = "Episodes: ${anime.episodes ?: "?"}")
        Text(text = "Score: ${anime.score} (${anime.scored_by} users)")
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeItemPreview() {
    val sampleAnime = AnimeData(
        mal_id = 1,
        title = "Naruto",
        episodes = 220,
        score = 8.5,
        scored_by = 1000,
        images = Images(
            jpg = Jpg(
                image_url = "https://cdn.myanimelist.net/images/anime/13/17405.jpg"
            )
        ),
        genres = listOf(
            Genre(mal_id = 1, name = "Action"),
            Genre(mal_id = 2, name = "Adventure"),
            Genre(mal_id = 3, name = "Shounen")
        ),
        title_english = "Naruto",
        title_japanese = "ナルト"
    )

    AnimeItem(sampleAnime)
}



