package com.example.fallinggeo.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fallinggeo.R
import com.example.fallinggeo.data.LevelObjArray
import kotlin.random.Random

class LevelListAdapter(val context: Context): RecyclerView.Adapter<LevelListAdapter.ViewHolder>() {

    inner  class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val levelButton: Button = view.findViewById(R.id.level_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_element_level_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val level = LevelObjArray[position]
        holder.levelButton.text =  level.name

        val color = Color.rgb((Random.nextInt()),(Random.nextInt()),(Random.nextInt()))
        holder.levelButton.setBackgroundColor(color)
        holder.view.setOnClickListener{
            Toast.makeText(context, level.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return LevelObjArray.size
    }


}