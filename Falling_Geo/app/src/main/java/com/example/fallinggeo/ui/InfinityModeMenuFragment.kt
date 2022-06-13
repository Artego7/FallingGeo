package com.example.fallinggeo.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fallinggeo.databinding.FragmentInfinityModeBinding
import com.example.fallinggeo.game.InfinityModeActivity

class InfinityModeMenuFragment : Fragment() {
    private lateinit var binding: FragmentInfinityModeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfinityModeBinding.inflate(inflater)
    binding.infinityModeButton.setOnClickListener{
        activity?.let{
            val intent = Intent (it, InfinityModeActivity::class.java)
            it.startActivity(intent)
        }

    }
        return binding.root
    }
}