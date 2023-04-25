package com.buanangelica.recordkeeper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import com.buanangelica.recordkeeper.cycling.CyclingFragment
import com.buanangelica.recordkeeper.databinding.ActivityMainBinding
import com.buanangelica.recordkeeper.running.RunningFragment

import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener{

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bottomNav.setOnItemSelectedListener(this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.reset_running -> {
            true
        }
        R.id.reset_cycling -> {
            true
        }
        R.id.rest_all -> {
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
    private fun onCyclingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
        return true
    }

    private fun onRunningClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem) =  when (item.itemId) {
            R.id.nav_cycling ->  onCyclingClicked()
            R.id.nav_running -> onRunningClicked()
            else -> false

        }
    }






