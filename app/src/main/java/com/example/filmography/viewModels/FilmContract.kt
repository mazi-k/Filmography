package com.example.filmography.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.filmography.models.FilmModel

class FilmContract {

    interface ViewModel{
        val filmsList: LiveData<List<FilmModel>>
        val film: MutableLiveData<FilmModel>

        fun getListFilms(): MutableLiveData<List<FilmModel>>
        fun getFilm(): FilmModel

        fun onItemClick(film: FilmModel)
        fun makeFavorite(film: FilmModel)
    }
}