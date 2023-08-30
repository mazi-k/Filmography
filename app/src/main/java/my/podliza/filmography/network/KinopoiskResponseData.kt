package my.podliza.filmography.network

import com.google.gson.annotations.SerializedName

data class KinopoiskResponseData(
    @SerializedName("total")
    val total: Int?,
    @SerializedName("items")
    val items: List<FilmResponseData>?,
)

data class FilmResponseData(
    @SerializedName("kinopoiskId")
    val id: Int,
    @SerializedName("nameRu")
    val name: String?,
    @SerializedName("nameOriginal")
    val alternativeName: String?,
    @SerializedName("year")
    val year: Int?,
    @SerializedName("ratingKinopoisk")
    val rate: Double?,
    @SerializedName("description")
    val description: String?,

)

data class FilmInfoResponseData(
    @SerializedName("kinopoiskId")
    val id: Int,
    @SerializedName("nameRu")
    val name: String?,
    @SerializedName("nameOriginal")
    val alternativeName: String?,
    @SerializedName("year")
    val year: Int?,
    @SerializedName("ratingKinopoisk")
    val rate: Double?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("posterUrl")
    val posterUrl: String?,
    )
