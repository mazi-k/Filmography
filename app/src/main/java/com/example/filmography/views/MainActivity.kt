package com.example.filmography.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.filmography.R
import com.example.filmography.databinding.ActivityMainBinding
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    private val fragmentMap = fillFragments()

    private lateinit var binding: ActivityMainBinding
    private var isLandscape = false
    private var isFirstLaunch = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(isFirstLaunch){
            createHomeFragment()
        }

        initBottomNavigationMenu()
    }

    private fun createHomeFragment() {
        isLandscape = resources.getBoolean(R.bool.isLandscape)

        if (isLandscape){
            startFragment(R.id.fragment_container_list, HomeFragment())
        } else {
            startFragment(R.id.fragment_container, HomeFragment())
        }
        isFirstLaunch = false
    }

    private fun initBottomNavigationMenu() {
        if (isLandscape) {
            binding.bottomNavigationMenu?.setOnItemSelectedListener { item: MenuItem -> run {
                fragmentMap[item.itemId]?.let { startFragment(R.id.fragment_container_content, it) }
            }
                true
            }
        } else {
            binding.bottomNavigationMenu?.setOnItemSelectedListener { item: MenuItem -> run {
                fragmentMap[item.itemId]?.let { startFragment(R.id.fragment_container, it) }
            }
                true
            }
        }
    }

    private fun fillFragments(): Map<Int, Fragment> {
        val fragments: MutableMap<Int, Fragment> = HashMap()
        fragments[R.id.menu_item_home] = HomeFragment()
        fragments[R.id.menu_item_favorites] = FavoritesFragment()
        fragments[R.id.menu_item_profile] = ProfileFragment()
        return fragments
    }

    private fun startFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(container, fragment).commit()
    }
}