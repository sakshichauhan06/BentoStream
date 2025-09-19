package com.example.bentostream.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SynopsisSection(synopsis: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Plot",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = synopsis,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

//@Preview
//@Composable
//fun SynopsisSectionPreview
