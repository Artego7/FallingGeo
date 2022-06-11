package com.example.fallinggeo.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fallinggeo.databinding.FragmentPlaneModeBinding

class PlaneModeFragment : Fragment() {
    private lateinit var binding: FragmentPlaneModeBinding
//    val buttonPanelMode= binding.planeModeButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaneModeBinding.inflate(inflater)

//        buttonPanelMode.setOnClickListener(){
//            //TESTING
//            startActivity(Intent(this, PlaneModeActivity::class.java))
//            finish()
//        }
        return binding.root
    }
}