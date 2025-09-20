package com.example.bentostream.ui.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.bentostream.data.AnimeData
import com.example.bentostream.data.Genre
import com.example.bentostream.data.Images
import com.example.bentostream.data.Jpg
import com.example.bentostream.data.Trailer

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AnimeItem(
    anime: AnimeData,
    onItemClick: (Int) -> Unit
) {
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { onItemClick(anime.mal_id) },
        verticalArrangement = Arrangement.Center
    ) {
        GlideImage(
            model = anime.images.jpg.image_url,
            contentDescription = anime.title,
            modifier = Modifier
                .padding(4.dp)
                .width(180.dp)
                .height(298.dp),
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 4.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Text(
                text = anime.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            HorizontalDivider(thickness = 1.dp, color = Color.Gray)

            // Alternative Titles
            Text(
                text = "Alternative Titles: ${anime.title_english}, ${anime.title_japanese}",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF797979)
                ),
                modifier = Modifier
                    .padding(2.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Genre
            Text(
                text = "${anime.genres.joinToString { it.name }}",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF797979)
                ),
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // No. of Episodes
            Text(
                text = "No. of episodes: ${anime.episodes ?: "?"}",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                ),
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Score
            Row {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star",
                    tint = Color(0xFFFFC107), // Material yellow
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = "Score: ${anime.score} (${anime.scored_by} users)",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                    ),
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
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
                image_url = "https://cdn.myanimelist.net/images/anime/1015/138006.jpg"
            )
        ),
        genres = listOf(
            Genre(mal_id = 1, name = "Action"),
            Genre(mal_id = 2, name = "Adventure"),
            Genre(mal_id = 3, name = "Shounen")
        ),
        title_english = "Naruto",
        title_japanese = "ナルト",
        synopsis = "A story about Naruto becoming Hokage",
        trailer = Trailer("", "", "")
    )

    AnimeItem(sampleAnime) { }
}
