package com.example.fallinggeo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fallinggeo.R
import com.example.fallinggeo.databinding.ActivityGameMenusBinding
import com.google.android.material.textfield.TextInputEditText

class GameMenusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameMenusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameMenusBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_game_menus)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment, LevelListFragment())
            .commitAllowingStateLoss()

        val levelButtonInput = findViewById<Button>(R.id.level_button)
        levelButtonInput.setOnClickListener(){
            startActivity(Intent(this, GameMenusActivity::class.java))
        }

    }


}