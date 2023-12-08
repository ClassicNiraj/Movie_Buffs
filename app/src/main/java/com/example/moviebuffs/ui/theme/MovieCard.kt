package com.example.moviebuffs.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun MovieCard(
    movieTitle: String,
    movieDescription: String,
    reviewScore: String,
    imageUrl: String // Replace with actual image loading logic
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .height(180.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image
            Image(
                painter = painterResource(id = R.drawable.loading_img), // Replace with actual image loading logic
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .width(120.dp),
                contentScale = ContentScale.Crop
            )

            // Text and Rating
            Column(
                modifier = Modifier.padding(end = 2.dp)
            ) {
                Text(
                    text = movieTitle,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = movieDescription,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Review Score",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = reviewScore,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
}