package com.buanangelica.recordkeeper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.buanangelica.recordkeeper.databinding.ActivityEditCyclingRecordBinding


class EditCyclingRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditCyclingRecordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCyclingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val distance = intent.getStringExtra("Distance")
        title = "$distance Record"
    }
}