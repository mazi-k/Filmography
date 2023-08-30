package my.podliza.filmography.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import coil.load
import my.podliza.filmography.R
import my.podliza.filmography.databinding.FragmentFilmBinding
import my.podliza.filmography.views.main.MainViewModel

class FilmFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
    }
    private lateinit var binding: FragmentFilmBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFilmBinding.bind(view)

        initFilm()
    }

    private fun initFilm() {
        val id = viewModel.film.value?.id!!
        viewModel.getInfo(id)
        viewModel.getLiveDataForViewToObserve().observe(viewLifecycleOwner) {
            it?.let {
                binding.screenTitleTextView.text = it.title
                binding.dateTextView.text = it.date
                binding.rateTextView.text = it.rate.toString()
                binding.descriptionTextView.text = it.description
                setAlterText(it.enTitle)
                binding.coverImageView.load(it.url)
            }
        }
    }

    private fun setAlterText(alterTitle: String) {
        if (alterTitle == ""){
            binding.titleAlterTextView.visibility = View.GONE
        } else {
            binding.titleAlterTextView.text = alterTitle
        }
    }
}