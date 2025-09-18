package com.example.bentostream.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bentostream.data.AnimeData


@Composable
fun AnimeItem(
    anime: AnimeData
) {
    Column {
        Text(
            text = anime.title
        )
    }
}

@Preview
@Composable
fun AnimeItemPreview() {
    val movie = AnimeData(
        mal_id = 1,
        title = "Naruto",
        title_english = "Naruto",
        title_japanese = "Naruto"
    )
    AnimeItem(movie)
}