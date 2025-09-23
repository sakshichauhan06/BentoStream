package com.example.bentostream.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TrailerSection(trailerUrl: String?) {
    if (trailerUrl.isNullOrEmpty()) return

    val context = LocalContext.current

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(41.dp)
                .background(Color(0xFFD3D4D6)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Trailer",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        val videoId = trailerUrl.substringAfter("v=", "")

        if (videoId.isNotEmpty()) {
            val thumbnailUrl = "https://img.youtube.com/vi/$videoId/0.jpg"

            GlideImage(
                model = thumbnailUrl,
                contentDescription = "Trailer Thumbnail",
                modifier = Modifier
                    .padding(12.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(trailerUrl))
                        context.startActivity(intent)
                    }
                    .size(width = 473.dp, height = 258.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrailerSectionPreview() {
    // Dummy YouTube trailer URL
    val sampleUrl = "https://www.youtube.com/watch?v=abcd1234"

    TrailerSection(trailerUrl = sampleUrl)
}

