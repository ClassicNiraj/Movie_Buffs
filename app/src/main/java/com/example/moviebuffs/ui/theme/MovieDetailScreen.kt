package com.example.moviebuffs.ui.theme

import android.content.res.Configuration
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.moviebuffs.network.Movie

@Composable
fun MovieDetailScreen(
    movie: Movie
) {
    fun calculateWindowSizeClass(configuration: Configuration) {

    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(top = 56.dp) // Padding for TopAppBar
    ) {
        Image(
            painter = painterResource(id = R.drawable.loading_img),
            contentDescription = movie.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            @Composable
            fun MoviesListAndDetails(viewModel: MovieViewModel) {
                val configuration = LocalConfiguration.current
                val windowSizeClass = calculateWindowSizeClass(configuration)

                if (windowSizeClass.widthSizeClass == WindowSizeClass.WidthSizeClass.EXPANDED) {
                    Row(modifier = Modifier.fillMaxSize()) {
                        // Assuming MovieList and MovieDetailScreen are already defined
                        MovieList(viewModel = viewModel, contentPadding = PaddingValues(0.dp))
                        viewModel.Movie?.let { movie ->
                            MovieDetailScreen(movie = movie)
                        }
                    }
                } else {
                    MovieList(viewModel = viewModel, contentPadding = PaddingValues(0.dp))
                }
            }
        }
    }
}