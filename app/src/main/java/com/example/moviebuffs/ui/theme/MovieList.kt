package com.example.moviebuffs.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviebuffs.ui.theme.MovieViewModel
import com.example.moviebuffs.network.Movie

@Composable
fun MovieList(
    viewModel: MovieViewModel,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    when (val uiState = viewModel.movieUiState) {
        is MoviesUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is MoviesUiState.Success -> MovieListContent(
            movies = uiState.movies,
            contentPadding = contentPadding
        )
        is MoviesUiState.Error -> ErrorScreen(/*...*/)
    }
}

@Composable
fun ErrorScreen() {
    TODO()
}

@Composable
fun MovieListContent(
    movies: List<Movie>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(movies) { movie ->
            MovieCard(Movie = movie, modifier = modifier.padding(4.dp).fillMaxWidth())
        }
    }
}