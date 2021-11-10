package com.example.filmography.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmography.models.FilmModel
import com.example.filmography.models.FilmsData

class FilmsViewModel: ViewModel(), FilmContract.ViewModel {

    override var filmsList: MutableLiveData<List<FilmModel>> = MutableLiveData()
    override var film: MutableLiveData<FilmModel> = MutableLiveData()

    init {
        filmsList.value = FilmsData.getFilms()
    }

    override fun getListFilms(): MutableLiveData<List<FilmModel>> {
        return filmsList
    }

    override fun getFilm(): FilmModel {
        return film.value!!
    }

    override fun onItemClick(choosedFilm: FilmModel) {
        film.postValue(choosedFilm)
    }

    override fun makeFavorite(film: FilmModel) {
        TODO("Not yet implemented")
    }





}