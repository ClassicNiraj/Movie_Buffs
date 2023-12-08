package com.example.moviebuffs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviebuffs.ui.theme.MovieBuffsTheme
import com.example.moviebuffs.ui.theme.MovieList
import com.example.moviebuffs.ui.theme.MovieDetailScreen
import com.example.moviebuffs.network.MovieApi
import com.example.moviebuffs.ui.theme.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieBuffsTheme {
                // ViewModel instance
                val viewModel = MovieViewModel()

                // UI State
                val uiState = viewModel.uiState.collectAsState().value

                Scaffold(
                    topBar = { TopAppBar(title = { Text("Movie Buffs") }) }
                ) { paddingValues ->
                    if (uiState.isShowingListPage) {
                        MovieList(
                            movies = viewModel.movieUiState,
                            modifier = Modifier.padding(paddingValues)
                        )
                    } else {
                        uiState.currentMovie?.let { movie ->
                            MovieDetailScreen(
                                movie = movie,
                                modifier = Modifier.padding(paddingValues)
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: @Composable () -> Unit) {
    CenterAlignedTopAppBar(
        title = title
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieBuffsTheme {
        TopAppBar(title = { Text("Movie Buffs") })
    }
}