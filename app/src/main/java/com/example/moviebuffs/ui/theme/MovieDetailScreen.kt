package com.example.moviebuffs.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MovieDetailScreen(
    movieTitle: String,
    movieDescription: String,
    imageUrl: String // Replace with actual image loading logic
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(top = 56.dp) // Padding for TopAppBar
    ) {
        Image(
            painter = painterResource(id = R.drawable.loading_img), // Replace with actual image loading logic
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movieTitle,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            // Add other movie details and icons here
        }
    }
}