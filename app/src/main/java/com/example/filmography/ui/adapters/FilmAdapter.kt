package com.example.filmography.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmography.R
import com.example.filmography.models.FilmModel
import com.example.filmography.ui.holders.FilmViewHolder
import java.util.ArrayList

class FilmAdapter(private val titles: ArrayList<String>): RecyclerView.Adapter<FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return FilmViewHolder(itemView)
    }

    private fun fillingRate (): ArrayList<String>{
        val list: ArrayList<String> = ArrayList<String>()
        list.add("8.0")
        list.add("6.2")
        list.add("9.6")
        list.add("8.1")
        return list
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.titleTextView?.text = titles.get(position)
        holder.rateTextView?.text = fillingRate().get(position)
        holder.dateTextView?.text = "2000"
    }

    override fun getItemCount()= titles.size
}