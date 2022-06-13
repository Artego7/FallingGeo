package com.example.fallinggeo.ui

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.recyclerview.widget.RecyclerView
import com.example.fallinggeo.R
import com.example.fallinggeo.data.LevelsHistory
import com.example.fallinggeo.data.LevelsHistoryObjArray
import com.google.android.material.snackbar.Snackbar

class LevelListAdapter(val context: Context, val levelHistoryItem: ArrayList<LevelsHistory>) : RecyclerView.Adapter<LevelListAdapter.ViewHolder>() {

    inner  class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val imageItem: ImageView = view.findViewById(R.id.image_item_list)
        val textItem: TextView = view.findViewById(R.id.text_item_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_element_level_list, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val level = levelHistoryItem[position]
        holder.textItem.text =  level.name
        when(level.image){
            R.drawable.level_template_1 -> holder.textItem.translationX = -370f
            R.drawable.level_template_2 -> holder.textItem.translationX = 0f
            R.drawable.level_template_3 -> holder.textItem.translationX = 370f
            R.drawable.level_template_4 -> holder.textItem.translationX = 0f
            R.drawable.level_template_5 -> holder.textItem.translationX = -370f
        }
        holder.imageItem.setImageResource(level.image)
        holder.imageItem.setOnClickListener { view ->
            Snackbar.make(view, "Proximamente", Snackbar.LENGTH_LONG)

        }
        holder.view.setOnClickListener{
            Toast.makeText(context, level.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return LevelsHistoryObjArray.size
    }


}