package com.example.fallinggeo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }




    }
    fun aaa(string: String){
        println(string)
    }
}