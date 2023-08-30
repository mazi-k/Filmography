package my.podliza.filmography.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.podliza.filmography.models.FilmModel
import my.podliza.filmography.models.OnItemClickListener
import my.podliza.filmography.ui.holders.FilmViewHolder

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
        holder.titleTextView?.text = data[position].title
        holder.dateTextView?.text = data[position].date

        if (data[position].rate == 0.0){
            holder.rateTextView?.visibility = View.INVISIBLE
        } else {
            holder.rateTextView?.text = data[position].rate.toString()
        }

        holder.itemView.setOnClickListener { clickListener.onItemClick(data[position]) }
    }

    override fun getItemCount()= data.size

}

