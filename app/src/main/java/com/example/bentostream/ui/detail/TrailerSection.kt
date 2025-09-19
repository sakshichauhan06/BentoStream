package com.example.bentostream.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TrailerSection(trailerUrl: String?) {
    if (trailerUrl == null) return

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Trailer", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        // Thumbnail clickable → open YouTube
        val context = LocalContext.current

    }
}
