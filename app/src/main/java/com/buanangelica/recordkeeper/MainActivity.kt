package com.buanangelica.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.commit
import com.buanangelica.recordkeeper.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("DEPRECATION")
 class MainActivity : AppCompatActivity(), View.OnClickListener,
    BottomNavigationView.OnNavigationItemReselectedListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bottomNav.setOnNavigationItemReselectedListener(this)


    }

    private fun onCyclingClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
    }

    private fun onRunningClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onNavigationItemSelected(item: MenuItem) : Boolean{
        return if (item.itemId == R.id.nav_cycling) {
            onCyclingClicked()
            true
        } else if (item.itemId == R.id.nav_running) {
            onRunningClicked()
            true
        }else {
            false
        }
        }




}
