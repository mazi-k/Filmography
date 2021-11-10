package com.example.filmography.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmography.R
import com.example.filmography.databinding.FragmentHomeBinding
import com.example.filmography.impl.FilmsRepositoryImpl
import com.example.filmography.models.FilmModel
import com.example.filmography.models.FilmsRepository
import com.example.filmography.models.OnItemClickListener
import com.example.filmography.ui.adapters.FilmAdapter
import com.example.filmography.viewModels.FilmsViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var repository: FilmsRepository

    private val viewModel by lazy { ViewModelProviders.of(this).get(FilmsViewModel::class.java)}

    private val listener: OnItemClickListener = object: OnItemClickListener{
        override fun onItemClick(item: FilmModel?) {
            Toast.makeText(context, "item " + item?.title, Toast.LENGTH_SHORT).show()
            if (item != null) {
                viewModel.onItemClick(item)
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
        val recyclerNew = binding.newFilmsRecyclerView
        recyclerNew.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerNew.adapter = adapter


        val recyclerWatching = binding.watchingFilmsRecyclerView
        recyclerWatching.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerWatching.adapter = adapter

        val recyclerRecommendations = binding.recommendationFilmsRecyclerView
        recyclerRecommendations.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerRecommendations.adapter = adapter
    }
}