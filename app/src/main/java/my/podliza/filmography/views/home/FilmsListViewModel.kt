package my.podliza.filmography.views.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.podliza.filmography.BuildConfig
import my.podliza.filmography.models.FilmModel
import my.podliza.filmography.network.KinopoiskResponseData
import my.podliza.filmography.network.KinopoiskRetrofitImpl
import my.podliza.filmography.viewModels.FilmContract
import my.podliza.filmography.viewModels.State
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsListViewModel(
    private val retrofitImpl: KinopoiskRetrofitImpl = KinopoiskRetrofitImpl(),
    private val liveDataForViewToObserveNew: MutableLiveData<State> = MutableLiveData(),
    private val liveDataForViewToObserveWatching: MutableLiveData<State> = MutableLiveData(),
    private val liveDataForViewToObserveRecommendation: MutableLiveData<State> = MutableLiveData(),
) : ViewModel(), FilmContract.ListViewModel {

    override var filmsList = MutableLiveData<List<FilmModel>>()
    override var film = MutableLiveData<FilmModel>()

    override fun getListFilms(): MutableLiveData<List<FilmModel>> {
        return filmsList
    }

    fun getLiveDataForViewToObserveNew() = liveDataForViewToObserveNew
    fun getLiveDataForViewToObserveWatching() = liveDataForViewToObserveWatching
    fun getLiveDataForViewToObserveRecommendation() = liveDataForViewToObserveRecommendation

    override fun makeFavorite(film: FilmModel) {
        TODO("Not yet implemented")
    }

    fun getKinopoiskFilms() {
        liveDataForViewToObserveWatching.postValue(State.Loading(null))
        retrofitImpl.getRetrofitImpl().getFilms(BuildConfig.X_API_KEY).enqueue(callbackNew)
    }

    fun getKinopoiskPremiers() {
        liveDataForViewToObserveNew.postValue(State.Loading(null))
        retrofitImpl.getRetrofitImpl().getPremiers(BuildConfig.X_API_KEY).enqueue(callbackWatching)
    }

    fun getGoodNewFilms() {
        liveDataForViewToObserveRecommendation.postValue(State.Loading(null))
        retrofitImpl.getRetrofitImpl().getGoodNewFilms(BuildConfig.X_API_KEY).enqueue(callbackRecommendation)
    }

    private fun refactor(list: KinopoiskResponseData): List<FilmModel> {
        val filmModels: MutableList<FilmModel> = mutableListOf()
        for (i in list.items!!) {
            filmModels.add(FilmModel(
                i.id,
                i.name?: "",
                i.alternativeName?: "",
                i.description?: "",
                i.year.toString(),
                i.rate?: 0.0, ""))
        }
        return filmModels
    }

    private val callbackNew = object : Callback<KinopoiskResponseData> {
        override fun onResponse(
            call: Call<KinopoiskResponseData>,
            response: Response<KinopoiskResponseData>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    val data = refactor(response.body() as KinopoiskResponseData)
                    liveDataForViewToObserveNew.postValue(State.ContentState(data))
                }
            } else {
                Log.e("@@@", "response 'New' failed: error " + response.code().toString())
            }
        }

        override fun onFailure(call: Call<KinopoiskResponseData>, t: Throwable) {
            Log.e("@@@", "response 'New' failed " + t.localizedMessage)
        }
    }

    private val callbackWatching = object : Callback<KinopoiskResponseData> {
        override fun onResponse(
            call: Call<KinopoiskResponseData>,
            response: Response<KinopoiskResponseData>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    val data = refactor(response.body() as KinopoiskResponseData)
                    liveDataForViewToObserveWatching.postValue(State.ContentState(data))
                }
            } else {
                Log.e("@@@", "response 'Watching' failed: error " + response.code().toString())
            }
        }

        override fun onFailure(call: Call<KinopoiskResponseData>, t: Throwable) {
            Log.e("@@@", "response 'Watching' failed " + t.localizedMessage)
        }
    }

    private val callbackRecommendation = object : Callback<KinopoiskResponseData> {
        override fun onResponse(
            call: Call<KinopoiskResponseData>,
            response: Response<KinopoiskResponseData>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    val data = refactor(response.body() as KinopoiskResponseData)
                    liveDataForViewToObserveRecommendation.postValue(State.ContentState(data))
                }
            } else {
                Log.e("@@@", "response 'Recommendation' failed: error " + response.code().toString())
            }
        }

        override fun onFailure(call: Call<KinopoiskResponseData>, t: Throwable) {
            Log.e("@@@", "response 'Recommendation failed " + t.localizedMessage)
        }
    }
}