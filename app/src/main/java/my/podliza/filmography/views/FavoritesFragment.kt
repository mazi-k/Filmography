package my.podliza.filmography.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import my.podliza.filmography.R
import my.podliza.filmography.databinding.FragmentFavoritesBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.logging.Logger

class FavoritesFragment: Fragment() {

    lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavoritesBinding.bind(view)

        initButton()
    }

    private fun initButton(){
        binding.getButton.setOnClickListener {
            val url = URL("https://api.kinopoisk.dev/v1.3/movie/1111")

            Thread{
                var connection: HttpURLConnection? = null
                try {
                    connection = url.openConnection() as HttpURLConnection
                    connection.requestMethod = "GET"
                    connection.connectTimeout = 5_000
                    connection.setRequestProperty("X-API-KEY", "3A57A61-NVX4X5A-NY5H8MV-109CFTY")

                    val bufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
                    val result = bufferedReader.readLines().toString()


                    activity?.runOnUiThread {
                        binding.resultTextView.text = result
                        var logger = Logger.getAnonymousLogger()
                        logger.info(result)
                        Toast.makeText(requireContext(), result, Toast.LENGTH_LONG).show()
                    }

                } finally {
                    connection?.disconnect()
                }
            }
        }
    }


}