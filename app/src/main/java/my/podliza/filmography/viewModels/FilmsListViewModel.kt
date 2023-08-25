package my.podliza.filmography.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.podliza.filmography.models.FilmModel
import my.podliza.filmography.models.FilmsData

class FilmsListViewModel: ViewModel(), FilmContract.ListViewModel {

    override var filmsList = MutableLiveData<List<FilmModel>>()
    override var film = MutableLiveData<FilmModel>()

    init {
        filmsList.value = FilmsData.getFilms()
        //TODO: add correct list
    }

    override fun getListFilms(): MutableLiveData<List<FilmModel>> {
        return filmsList
    }

    override fun makeFavorite(film: FilmModel) {
        TODO("Not yet implemented")
    }
}