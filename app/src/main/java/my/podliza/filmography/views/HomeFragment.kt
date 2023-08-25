package my.podliza.filmography.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import my.podliza.filmography.viewModels.FilmsListViewModel
import my.podliza.filmography.viewModels.MainViewModel

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

    private val adapter = FilmAdapter(listener)

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        initRepository()
        initRecyclerView()
    }

    private fun initRepository() {
        viewModel.getListFilms().observe(viewLifecycleOwner, { it?.let {
            adapter.setData(it)
        } })
    }

    private fun initRecyclerView() {
        val recyclerNew = binding!!.newFilmsRecyclerView
        recyclerNew.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerNew.adapter = adapter

        val recyclerWatching = binding!!.watchingFilmsRecyclerView
        recyclerWatching.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerWatching.adapter = adapter

        val recyclerRecommendations = binding!!.recommendationFilmsRecyclerView
        recyclerRecommendations.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerRecommendations.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}