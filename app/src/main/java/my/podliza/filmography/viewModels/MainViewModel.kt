package my.podliza.filmography.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.podliza.filmography.models.FilmModel

class MainViewModel: ViewModel() {

    val film = MutableLiveData<FilmModel>()

}