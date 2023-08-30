package my.podliza.filmography.views.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.podliza.filmography.BuildConfig
import my.podliza.filmography.models.FilmModel
import my.podliza.filmography.network.FilmInfoResponseData
import my.podliza.filmography.network.KinopoiskRetrofitImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val retrofitImpl: KinopoiskRetrofitImpl = KinopoiskRetrofitImpl(),
    private val liveDataForViewToObserve: MutableLiveData<FilmModel> = MutableLiveData(),
) : ViewModel() {

    val film = MutableLiveData<FilmModel>()

    fun getLiveDataForViewToObserve() = liveDataForViewToObserve

    fun getInfo(id: Int) {
        liveDataForViewToObserve.postValue(FilmModel(0, "", "", "", "", 0.0, "" ))
        retrofitImpl.getRetrofitImpl().getInfoById(BuildConfig.X_API_KEY, id).enqueue(callback)
    }

    private fun refactor(film: FilmInfoResponseData): FilmModel {
        return FilmModel(
            film.id,
            film.name?: "",
            film.alternativeName ?: "",
            film.description?: "",
            (film.year?:0).toString(),
            film.rate?: 0.0,
            film.posterUrl ?: ""
        )
    }


    private val callback = object : Callback<FilmInfoResponseData> {
        override fun onResponse(
            call: Call<FilmInfoResponseData>,
            response: Response<FilmInfoResponseData>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    val data = refactor(response.body() as FilmInfoResponseData)
                    liveDataForViewToObserve.postValue(data)
                }
            } else {
                Log.e("@@@", "response 'Film' failed: error " + response.code().toString())
            }
        }

        override fun onFailure(call: Call<FilmInfoResponseData>, t: Throwable) {
            Log.e("@@@", "response 'Film' failed " + t.localizedMessage)
        }
    }

}