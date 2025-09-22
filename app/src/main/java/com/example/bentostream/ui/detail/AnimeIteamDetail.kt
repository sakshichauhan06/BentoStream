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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
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
fun AnimeItemDetail(
    anime: AnimeData,
) {
    Column (
        modifier = Modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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
                .padding(vertical = 8.dp)
        )

        GlideImage(
            model = anime.images.jpg.image_url,
            contentDescription = anime.title,
            modifier = Modifier
                .padding(6.dp)
                .width(244.dp)
                .height(348.dp),
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Alternative Titles
            Text(
                text = "Alternative Titles: ",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black
                ),
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 4.dp)
            )
            Text(
                text = "English: ${anime.title_english}",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                modifier = Modifier
                    .padding(bottom = 3.dp)

            )
            Text(
                text = "Japanese: ${anime.title_japanese}",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                modifier = Modifier
                    .padding(bottom = 6.dp)
            )

            // Genre
            Text(
                text = "Genres",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    textDecoration = TextDecoration.Underline,
                    color = Color(0xFF797979)
                ),
                modifier = Modifier
                    .padding(bottom = 3.dp)
            )
            Text(
                text = "${anime.genres.joinToString { it.name }}",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF797979)
                ),
                modifier = Modifier
                    .padding(bottom = 6.dp)
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
                    .padding(bottom = 6.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Score
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star",
                    tint = Color(0xFFFFC107), // Material yellow
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("${anime.score}")
                        }

                        append(" by ")

                        val usersK = anime.scored_by?.let {
                            if(it >= 1000) {
                                "${anime.scored_by / 1000}k"
                            } else {
                                anime.scored_by.toString()
                            }
                        }
                        
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black
                            )
                        ) {
                            append("$usersK users")
                        }
                    },
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                    ),
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeItemDetailPreview() {
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

    AnimeItemDetail(sampleAnime)
}
