package com.example.bentostream.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bentostream.data.AnimeData

@Composable
fun SynopsisSection(
    anime: AnimeData,
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(41.dp)
                .background(Color(0xFFD3D4D6)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Synopsis",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Text(
            text = anime.synopsis,
            fontSize = 14.sp,
            modifier = Modifier.padding(12.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SynopsisSectionPreview() {
//    val fakeAnime = AnimeData(
//        mal_id = 1,
//        title = "Naruto",
//        episodes = 220,
//        score = 8.5,
//        scored_by = 1000,
//        images = null, // you can put null if not needed for preview
//        genres = emptyList(),
//        title_english = "Naruto",
//        title_japanese = "ナルト",
//        synopsis = "Naruto Uzumaki, a hyperactive ninja, seeks recognition and dreams of becoming Hokage.",
//        trailer = null // put null if not needed for preview
//    )
//
//    SynopsisSection(anime = fakeAnime)
//}

