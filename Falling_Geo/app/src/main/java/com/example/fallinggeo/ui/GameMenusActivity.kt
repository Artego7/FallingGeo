package com.example.fallinggeo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.example.fallinggeo.R
import com.example.fallinggeo.databinding.ActivityGameMenusBinding
import com.example.fallinggeo.ui.SectionPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText

class GameMenusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameMenusBinding
    val buttonPanelMode= findViewById<Button>(R.id.plane_mode_button)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameMenusBinding.inflate(layoutInflater)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_fragment, LevelListFragment())
//            .commitAllowingStateLoss()
        setContentView(binding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionPagerAdapter

        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(binding.viewPager)
        buttonPanelMode.setOnClickListener(){
            //TESTING
            startActivity(Intent(this, PlaneModeActivity::class.java))
            finish()
        }

//        val levelButtonInput = findViewById<Button>(R.id.level_button)
//        levelButtonInput.setOnClickListener(){
//            startActivity(Intent(this, GameMenusActivity::class.java))
        }

    }

