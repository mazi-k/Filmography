package com.example.filmography.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmography.models.FilmModel
import com.example.filmography.models.FilmsData

class FilmsListViewModel: ViewModel(), FilmContract.ListViewModel {

    override var filmsList = MutableLiveData<List<FilmModel>>()
    override var film = MutableLiveData<FilmModel>()

    init {
        filmsList.value = FilmsData.getFilms()
    }

    override fun getListFilms(): MutableLiveData<List<FilmModel>> {
        return filmsList
    }

    override fun makeFavorite(film: FilmModel) {
        TODO("Not yet implemented")
    }
}