package com.example.filmography.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmography.R
import com.example.filmography.databinding.FragmentHomeBinding
import com.example.filmography.models.FilmModel
import com.example.filmography.ui.adapters.FilmAdapter
import java.util.ArrayList

class HomeFragment: Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        val recycler = binding!!.filmsListRecyclerView
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = FilmAdapter(fillingTitles())

        val recycler2 = binding!!.filmsListRecyclerView2
        recycler2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler2.adapter = FilmAdapter(fillingTitles())
    }

    private fun fillingTitles(): ArrayList<String> {
        val list: ArrayList<String> = ArrayList<String>()
        list.add("1+1")
        list.add("Titanic")
        list.add("Shreck")
        list.add("Friends")
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}