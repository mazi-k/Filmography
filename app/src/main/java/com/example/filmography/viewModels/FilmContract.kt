package com.example.filmography.viewModels

import androidx.lifecycle.LiveData
import com.example.filmography.models.FilmModel

class FilmContract {
    interface ListViewModel{
        val filmsList: LiveData<List<FilmModel>>
        val film: LiveData<FilmModel>

        fun getListFilms(): LiveData<List<FilmModel>>
        fun makeFavorite(film: FilmModel)
    }
}

sealed class State

data class ErrorState(val throwable: Throwable): State()
data class ContentState(val list: List<FilmModel>): State()
object IdleState: State()