package my.podliza.filmography.views.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import my.podliza.filmography.R
import my.podliza.filmography.databinding.FragmentHomeBinding
import my.podliza.filmography.impl.FilmsRepositoryImpl
import my.podliza.filmography.models.FilmModel
import my.podliza.filmography.models.FilmsRepository
import my.podliza.filmography.models.OnItemClickListener
import my.podliza.filmography.ui.adapters.FilmAdapter
import my.podliza.filmography.viewModels.State
import my.podliza.filmography.views.main.MainViewModel

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private lateinit var repository: FilmsRepository

    private val viewModel by lazy { ViewModelProviders.of(requireActivity()).get(FilmsListViewModel::class.java)}
    private val viewModelMain by lazy { ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)}

    private val listener: OnItemClickListener = object: OnItemClickListener {
        override fun onItemClick(item: FilmModel?) {
            if (item != null) {
                viewModelMain.film.postValue(item)
            }
        }
    }

    private val adapterNew = FilmAdapter(listener)
    private val adapterWatching = FilmAdapter(listener)
    private val adapterRecommendation = FilmAdapter(listener)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        repository = FilmsRepositoryImpl()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        viewModel.getKinopoiskPremiers()
        viewModel.getLiveDataForViewToObserveNew().observe(viewLifecycleOwner) {
            renderData(it, adapterNew)
            initRecyclerNew()
        }

        viewModel.getKinopoiskFilms()
        viewModel.getLiveDataForViewToObserveWatching().observe(viewLifecycleOwner) {
            renderData(it, adapterWatching)
            initRecyclerWatching()
        }

        viewModel.getGoodNewFilms()
        viewModel.getLiveDataForViewToObserveRecommendation().observe(viewLifecycleOwner) {
            renderData(it, adapterRecommendation)
            initRecyclerRecommendation()
        }
    }

    private fun initRecyclerNew() {
        val recyclerNew = binding!!.newFilmsRecyclerView
        recyclerNew.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerNew.adapter = adapterNew
    }

    private fun initRecyclerWatching(){
        val recyclerWatching = binding!!.watchingFilmsRecyclerView
        recyclerWatching.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerWatching.adapter = adapterWatching
    }

    private fun initRecyclerRecommendation(){
        val recyclerRecommendations = binding!!.recommendationFilmsRecyclerView
        recyclerRecommendations.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerRecommendations.adapter = adapterRecommendation
    }

    private fun renderData(appState: State, adapter: FilmAdapter) {
        when (appState) {
            is State.ErrorState -> {
                adapter.setData(emptyList())
            }
            is State.Loading -> {
                adapter.setData(emptyList())
            }
            is State.ContentState -> {
                adapter.setData(appState.data)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}