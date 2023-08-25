package my.podliza.filmography.models

import my.podliza.filmography.R

class FilmModel (
    _id: Int,
    _title: String,
    _description: String,
    _date: String,
    _rate: Double) {

    var id = _id
    val title = _title
    val description = _description
    val date = _date
    val rate = _rate
    var image = R.drawable.ic_favorite

    constructor(id: Int,
                _title: String,
                _description: String,
                _date: String,
                _rate: Double,
                _image: Int
    ) : this(_id = 0, _title, _description, _date, _rate) {
        image = _image
    }

}