package com.example.bentostream.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TrailerSection(trailerUrl: String?) {
    if (trailerUrl.isNullOrEmpty()) return

    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Trailer", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        val videoId = trailerUrl.substringAfter("v=", "")
        if (videoId.isNotEmpty()) {
            val thumbnailUrl = "https://img.youtube.com/vi/$videoId/0.jpg"

            GlideImage(
                model = thumbnailUrl,
                contentDescription = "Trailer Thumbnail",
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(trailerUrl))
                        context.startActivity(intent)
                    }
            )
        }
    }
}

