package my.podliza.filmography.ui.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import my.podliza.filmography.R
import my.podliza.filmography.databinding.ItemFilmBinding
import my.podliza.filmography.models.FilmModel
import my.podliza.filmography.models.OnItemClickListener

class FilmViewHolder(parent: ViewGroup, clickListener: OnItemClickListener) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
        .inflate(R.layout.item_film, parent, false)) {

    private var binding = ItemFilmBinding.bind(itemView)
    private var film: FilmModel? = null

    var titleTextView: TextView? = null
    var rateTextView: TextView? = null
    var dateTextView: TextView? = null
    var coverImageView: ImageView? = null

    init {
        itemView.setOnClickListener { v: View? -> clickListener.onItemClick(film)  }

        titleTextView = binding.titleTextView
        rateTextView = binding.rateTextView
        dateTextView = binding.dateTextView
        coverImageView = binding.coverImageView
    }



}