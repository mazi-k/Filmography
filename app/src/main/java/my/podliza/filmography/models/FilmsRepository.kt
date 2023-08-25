package my.podliza.filmography.models

interface FilmsRepository {

    fun getFilms(): ArrayList<FilmModel>

    fun addFilm(film: FilmModel): Int
    fun deleteFilm(id: Int)
    fun updateFilm(id: Int, newFilm: FilmModel)
}