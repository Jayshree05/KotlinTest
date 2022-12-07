package com.example.kotlintest.navigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityNavigationBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityNavigationBinding


    private val navController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation)


        val toggle = ActionBarDrawerToggle(
                this, binding.drawermenu, binding.appbar.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.drawermenu.addDrawerListener(toggle)
        toggle.syncState()


        binding.navView.setNavigationItemSelectedListener(this)

        displayScreen(-1)
    }

    override fun onBackPressed() {
        if (binding.drawermenu.isDrawerOpen(GravityCompat.START)) {
            binding.drawermenu.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun displayScreen(id: Int){
        when (id){
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, HomeFragment()).addToBackStack(null).commit()
            }

            R.id.nav_photos -> {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, PhotosFragment()).addToBackStack(null).commit()
            }

            R.id.nav_movies -> {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, MoviesFragment()).addToBackStack(null)
                    .commit()
            }

           R.id.nav_notifications -> {
               Toast.makeText(this, "Clicked Notifications", Toast.LENGTH_SHORT).show()
           }

           R.id.nav_settings -> {
               Toast.makeText(this, "Clicked Settings", Toast.LENGTH_SHORT).show()
           }

           R.id.nav_aboutUs -> {
               Toast.makeText(this, "Clicked About Us", Toast.LENGTH_SHORT).show()
           }

           R.id.nav_privacyPolicy -> {
               Toast.makeText(this, "Clicked Privacy Policy", Toast.LENGTH_SHORT).show()
           }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        displayScreen(item.itemId)
        binding.drawermenu.closeDrawer(GravityCompat.START)
        return true
    }


}