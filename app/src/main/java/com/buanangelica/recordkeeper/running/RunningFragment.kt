package com.buanangelica.recordkeeper.running

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.buanangelica.recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    //data binding class for the "RunningFragment" layout
    private lateinit var binding: FragmentRunningBinding


    //This function is called when the fragment is first created. It inflates the layout for the fragment and returns a View object.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root

    }

    //This function is called when the view for the fragment has been created. It sets up click listeners for different distance containers.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        displayRecords()


    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }
    private fun displayRecords() {
        val runningPreferences = requireContext().getSharedPreferences("running", Context.MODE_PRIVATE)

        binding.textView5kmValue.text = runningPreferences.getString("5km record",null)
        binding.textView5kmDate.text = runningPreferences.getString("5km date", null)

        binding.textView10kmValue.text = runningPreferences.getString("10km record",null)
        binding.textView10kmDate.text = runningPreferences.getString("10km date", null)

        binding.textViewHalfMarathonValue.text = runningPreferences.getString("Half Marathon record",null)
        binding.textViewHalfMarathonDate.text = runningPreferences.getString("Half Marathon date", null)

        binding.textViewMarathonValue.text = runningPreferences.getString("Marathon record",null)
        binding.textViewHalfMarathonDate.text = runningPreferences.getString("Marathon date", null)

    }

    //This function sets up click listeners for different distance containers, which are defined in the layout file for the fragment.
    private fun setupClickListeners() {
        binding.container5km.setOnClickListener { launchRunningRecordScreen("5km") }
        binding.container10km.setOnClickListener { launchRunningRecordScreen("10km") }
        binding.containerHalfMarathon.setOnClickListener { launchRunningRecordScreen("Half Marathon") }
        binding.containerMarathon.setOnClickListener { launchRunningRecordScreen("Marathon") }


    }

    //This function launches an activity called "EditRunningRecordActivity" using an intent. The distance value is passed to the activity as an extra parameter.
    private fun launchRunningRecordScreen(distance: String) {

        //in fragment use "context" instead of "this" which id used in activity
        val intent = Intent(context, EditRunningRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }


}