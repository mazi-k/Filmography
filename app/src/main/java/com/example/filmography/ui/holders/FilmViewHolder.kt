package com.example.filmography.ui.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmography.databinding.ItemFilmBinding

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = ItemFilmBinding.bind(itemView)
    var titleTextView: TextView? = null
    var rateTextView: TextView? = null
    var dateTextView: TextView? = null
    var coverImageView: ImageView? = null

    init {
        titleTextView = binding.titleTextView
        rateTextView = binding.rateTextView
        dateTextView = binding.dateTextView
        coverImageView = binding.coverImageView
    }



}