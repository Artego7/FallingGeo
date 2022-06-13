package com.example.fallinggeo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fallinggeo.data.LevelsHistoryObjArray
import com.example.fallinggeo.databinding.FragmentHistoryModeBinding

/**
 * A fragment representing a list of Items.
 */
class HistoryModeMenuFragment : Fragment() {

    private lateinit var binding:FragmentHistoryModeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryModeBinding.inflate(inflater)

        val ctx = context ?: return binding.root.also { activity?.finish() }

        binding.levelList.adapter = LevelListAdapter(ctx, LevelsHistoryObjArray)

        return binding.root
    }
}