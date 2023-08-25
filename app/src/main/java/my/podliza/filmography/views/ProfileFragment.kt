package my.podliza.filmography.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import my.podliza.filmography.R
import my.podliza.filmography.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar

class ProfileFragment: Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)

        initButton()
    }

    private fun initButton(){
        binding.sayHelloButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            if (name != ""){
                it.showSnack(name)
            } else {
                it.showSnack(resources.getString(R.string.anonim))
            }

        }

        binding.sayAppNameButton.setOnClickListener {
            it.showSnack(R.string.app_name)
        }
    }

    private fun View.showSnack(name: String) {
        val snackbar = Snackbar.make(
            this,
            resources.getString(R.string.hello) + name,
            Snackbar.LENGTH_LONG
        )
        snackbar.show()
    }

    private fun View.showSnack(name: Int) {
        val snackbar = Snackbar.make(this, resources.getString(name), Snackbar.LENGTH_LONG)
        snackbar.show()
    }


}