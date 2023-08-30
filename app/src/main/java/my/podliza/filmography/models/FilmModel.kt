package my.podliza.filmography.models


class FilmModel (
    _id: Int,
    _title: String,
    _enTitle: String,
    _description: String,
    _date: String,
    _rate: Double,
    _url: String) {

    var id = _id
    val title = _title
    var enTitle = _enTitle
    val description = _description
    val date = _date
    val rate = _rate
    val url = _url

}