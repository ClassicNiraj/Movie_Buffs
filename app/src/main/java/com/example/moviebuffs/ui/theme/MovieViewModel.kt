package com.example.moviebuffs.ui.theme

import android.graphics.Movie
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebuffs.network.MovieApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MoviesUiState{
    data class Success(val movies: String) : MoviesUiState
    object Error : MoviesUiState
    object Loading : MoviesUiState
}

data class UiState(
    val currentMovie: Movie?,
    val isShowingListPage: Boolean = true
)
class MovieViewModel : ViewModel() {
    var movieUiState: MoviesUiState by mutableStateOf(MoviesUiState.Loading)
        private set

private val _uiState = MutableStateFlow(
    UiState(
        currentMovie = null,
        isShowingListPage = true
    )
)
val uiState: StateFlow<UiState> = _uiState
    init {
        getMovie()
    }

    fun updateCurrentMovie(selectedMovie: Movie){
        _uiState.update{
            it.copy(currentMovie = selectedMovie)
        }
    }

    fun navigateToListPage(){
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    fun navitageToDetailPage(){
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
    fun getMovie() {
        viewModelScope.launch{
            movieUiState = try{
                MoviesUiState.Success(MovieApi.retrofitService.getMovies())
            } catch(e:IOException){
                MoviesUiState.Error
            }
        }
    }
}