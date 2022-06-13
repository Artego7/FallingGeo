package com.example.fallinggeo.game

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.fallinggeo.R
import com.example.fallinggeo.data.PlayerObjArray
import com.example.fallinggeo.ui.GameMenusActivity


class InfinityModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_infinity)

        val playerInfinityInit = findViewById<ImageView>(R.id.player_infinity)
        val constrain = findViewById<ConstraintLayout>(R.id.infinity_game_mode_constrain)
        val tape = findViewById<ImageView>(R.id.tape_infinity)
        val pointsInit = findViewById<TextView>(R.id.points_text)

        //-------------------- Restart & Pause --------------------//
        val buttonPause = findViewById<ImageView>(R.id.pause_button_infinity)
        val layerPause = findViewById<ImageView>(R.id.pause_menu_infinity)
        val pauseRestartText = findViewById<TextView>(R.id.pause_text_infinity)
        val buttonRestart = findViewById<ImageView>(R.id.restart_image)
        val buttonResume = findViewById<Button>(R.id.resume_button_infinity)
        val buttonReturn = findViewById<Button>(R.id.back_button_infinity)
        //-- Init Pause & Restart --//
        layerPause.visibility = View.INVISIBLE
        pauseRestartText.visibility = View.INVISIBLE
        buttonRestart.visibility = View.INVISIBLE
        buttonResume.visibility = View.INVISIBLE
        buttonReturn.visibility = View.INVISIBLE

        //-- Active Pause & Restart --//
        buttonPause.setOnClickListener(){
            PlayerObjArray.isPause = true
            layerPause.visibility = View.VISIBLE
            pauseRestartText.visibility = View.VISIBLE
            buttonResume.visibility = View.VISIBLE
            buttonReturn.visibility = View.VISIBLE
            pauseRestartText.text = "Pause"
        }
        buttonResume.setOnClickListener(){
            PlayerObjArray.isPause = false
            layerPause.visibility = View.INVISIBLE
            pauseRestartText.visibility = View.INVISIBLE
            buttonResume.visibility = View.INVISIBLE
            buttonReturn.visibility = View.INVISIBLE
        }
        buttonReturn.setOnClickListener(){
            PlayerObjArray.isPlaying = true
            PlayerObjArray.isPause = false
            startActivity(Intent(this, GameMenusActivity::class.java))
            finish()
        }
        //No va bien
        buttonRestart.setOnClickListener(){
            PlayerObjArray.isPause = false
            layerPause.visibility = View.INVISIBLE
            pauseRestartText.visibility = View.INVISIBLE
            buttonRestart.visibility = View.INVISIBLE
            buttonReturn.visibility = View.INVISIBLE
        }
        //---------------- Screen Width & Height ----------------//
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            val screenHeight = displayMetrics.heightPixels
            val screenWidth = displayMetrics.widthPixels
        //------------------------------------------------------//
        PlayerObjArray.setPlayer(playerInfinityInit, pointsInit)
        PlayerObjArray.setSpawnTape(tape, displayMetrics)
        constrain.setOnClickListener(){
            if(PlayerObjArray.isPlaying){
                PlayerObjArray.changeTape(tape)
            }
        }
        //----------------- Game Actions -----------------//
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(object : Runnable {
            override fun run() {
                if(!PlayerObjArray.isPause){
                    PlayerObjArray.update(tape, playerInfinityInit,
                        pointsInit, layerPause, pauseRestartText,
                        buttonRestart, buttonReturn, displayMetrics)
                }
                mainHandler.postDelayed(this, 16)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        //-------------------- Restart & Pause --------------------//
        val buttonPause = findViewById<ImageView>(R.id.pause_button_infinity)
        val layerPause = findViewById<ImageView>(R.id.pause_menu_infinity)
        val pauseRestartText = findViewById<TextView>(R.id.pause_text_infinity)
        val buttonRestart = findViewById<ImageView>(R.id.restart_image)
        val buttonResume = findViewById<Button>(R.id.resume_button_infinity)
        val buttonReturn = findViewById<Button>(R.id.back_button_infinity)

        layerPause.visibility = View.INVISIBLE
        pauseRestartText.visibility = View.INVISIBLE
        buttonRestart.visibility = View.INVISIBLE
        buttonResume.visibility = View.INVISIBLE
        buttonReturn.visibility = View.INVISIBLE
        PlayerObjArray.isPlaying = true
        PlayerObjArray.isPause = false
    }
}
