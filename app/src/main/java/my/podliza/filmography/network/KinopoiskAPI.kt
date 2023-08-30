package my.podliza.filmography.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface KinopoiskAPI {

    @GET("api/v2.2/films")
    fun getFilms(@Header("X-API-KEY") apiKey: String): Call<KinopoiskResponseData>

    @GET("api/v2.2/films/premieres?year=2023&month=JANUARY")
    fun getPremiers(@Header("X-API-KEY") apiKey: String): Call<KinopoiskResponseData>

    @GET("api/v2.2/films?type=ALL&ratingFrom=7&ratingTo=10&yearFrom=2000&yearTo=3000&page=1")
    fun getGoodNewFilms(@Header("X-API-KEY") apiKey: String): Call<KinopoiskResponseData>

    @GET("api/v2.2/films/{id}")
    fun getInfoById(@Header("X-API-KEY") apiKey: String, @Path("id") id: Int): Call<FilmInfoResponseData>
}

//order=RATING&