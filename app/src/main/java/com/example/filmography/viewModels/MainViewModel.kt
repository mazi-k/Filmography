package com.example.filmography.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmography.models.FilmModel

class MainViewModel: ViewModel() {

    val film = MutableLiveData<FilmModel>()

}