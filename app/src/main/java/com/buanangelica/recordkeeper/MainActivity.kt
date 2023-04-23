package com.buanangelica.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.commit
import com.buanangelica.recordkeeper.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView



 class MainActivity : AppCompatActivity(), com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener{

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bottomNav.setOnItemSelectedListener(this)


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
}





