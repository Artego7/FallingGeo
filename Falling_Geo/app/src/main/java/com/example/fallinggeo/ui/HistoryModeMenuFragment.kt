package com.example.fallinggeo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
//        val view =  inflater.inflate(R.layout.fragment_history_mode, container, false)
//        context?.let {
//            view.findViewById<RecyclerView>(R.id.level_list).adapter = LevelListAdapter(it)
//        }
//        return view
        return binding.root
    }
}