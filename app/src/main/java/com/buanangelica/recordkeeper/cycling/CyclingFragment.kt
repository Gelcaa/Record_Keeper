package com.buanangelica.recordkeeper.cycling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.buanangelica.recordkeeper.databinding.FragmentCyclingBinding

class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.containerLongestRide.setOnClickListener {launchCyclingRecordScreen("Longest Ride")}
        binding.containerBiggerClimb.setOnClickListener {launchCyclingRecordScreen("Bigger Climb")}
        binding.containerAverageSpeed.setOnClickListener {launchCyclingRecordScreen("Best Average Speed")}
        }

    private fun launchCyclingRecordScreen(distance: String) {
    val intent = Intent(context, EditCyclingRecordActivity::class.java )
    intent.putExtra("Distance", distance)
        startActivity(intent)
    }

}
