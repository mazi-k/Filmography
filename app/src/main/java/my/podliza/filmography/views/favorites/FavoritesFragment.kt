package my.podliza.filmography.views.favorites

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import my.podliza.filmography.R
import my.podliza.filmography.databinding.FragmentFavoritesBinding
import my.podliza.filmography.network.KinopoiskRetrofitImpl

class FavoritesFragment : Fragment() {

    lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavoritesBinding.bind(view)

        initButton()
    }

    private fun initButton() {
        binding.getButton.setOnClickListener {}
    }
}