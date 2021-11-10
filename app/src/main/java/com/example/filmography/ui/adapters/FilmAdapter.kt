package com.example.filmography.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmography.models.FilmModel
import com.example.filmography.models.OnItemClickListener
import com.example.filmography.ui.holders.FilmViewHolder

class FilmAdapter(listener: OnItemClickListener): RecyclerView.Adapter<FilmViewHolder>() {

    private lateinit var data: List<FilmModel>
    private val clickListener: OnItemClickListener = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(parent, clickListener)
    }

    fun setData(data: List<FilmModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.titleTextView?.text = data.get(position).title
        holder.rateTextView?.text = data.get(position).rate.toString()
        holder.dateTextView?.text = data.get(position).date

        holder.itemView.setOnClickListener { clickListener.onItemClick(data.get(position)) }
    }

    override fun getItemCount()= data.size

}

