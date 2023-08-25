package my.podliza.filmography.impl

import my.podliza.filmography.models.FilmModel
import my.podliza.filmography.models.FilmsRepository

class FilmsRepositoryImpl: FilmsRepository {

    private var cache: ArrayList<FilmModel> = ArrayList()

    private var counter = 0

    override fun getFilms(): ArrayList<FilmModel> {
        return ArrayList(cache)
    }

    override fun addFilm(film: FilmModel): Int {
        val newId = ++counter
        film.id = newId
        cache.add(film)
        return newId
    }

    override fun deleteFilm(id: Int) {
        for (i in cache.indices) {
            if (cache[i].id == id) {
                cache.removeAt(i)
                --counter
            }
        }
    }

    override fun updateFilm(id: Int, newFilm: FilmModel) {
        TODO("Not yet implemented")
    }
}