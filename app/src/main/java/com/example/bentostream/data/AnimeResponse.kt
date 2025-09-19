package com.example.bentostream.data

import android.provider.MediaStore

data class AnimeResponse(
    val data: List<AnimeData>
)

data class AnimeData(
    val mal_id: Int,
    val title: String,
    val title_english: String,
    val title_japanese: String,
    val episodes: Int?,
    val score: Double?,
    val scored_by: Int?,
    val images: Images,
    val genres: List<Genre>,
    val synopsis: String,
    val trailer: Trailer
)

data class Images(
    val jpg: Jpg
)

data class Jpg(
    val image_url: String
)

data class Genre(
    val mal_id: Int,
    val name: String,
)

data class Trailer(
    val youtube_id: String,
    val url: String,
    val embed_url: String
)