package com.example.fallinggeo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fallinggeo.databinding.FragmentInfinityModeBinding

class InfinityModeMenuFragment : Fragment() {
    private lateinit var binding: FragmentInfinityModeBinding

//    val buttonInfinitMode= binding.infinitModeButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfinityModeBinding.inflate(inflater)
//        buttonInfinitMode.setOnClickListener(){
//            val intent = Intent (getActivity(), InfinitModeActivity::class.java)
//            getActivity()?.startActivity(intent)
//        }
        return binding.root
    }
}