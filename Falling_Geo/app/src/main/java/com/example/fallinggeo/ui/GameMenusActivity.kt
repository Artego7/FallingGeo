package com.example.fallinggeo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fallinggeo.MainActivity
import com.example.fallinggeo.R
import com.example.fallinggeo.databinding.ActivityGameMenusBinding


class GameMenusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameMenusBinding
    private var needsRefresh = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameMenusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionPagerAdapter

        binding.tabs.setupWithViewPager(binding.viewPager)

        //-----------Esto gestiona el menú desplegable-----------//
        binding.menuButton.setOnMenuItemClickListener() { menuItem ->
            when (menuItem.itemId) {
                R.id.logOutItemMenu -> logout()
                    .also { needsRefresh = true }
                else -> return@setOnMenuItemClickListener false
            }
            true
        }
    }

    override fun onResume(){
        super.onResume()
        if (needsRefresh) {
            needsRefresh = false

        }
    }
    private fun logout() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    }

