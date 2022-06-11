package com.example.fallinggeo.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.fallinggeo.MainActivity
import com.example.fallinggeo.R
import com.example.fallinggeo.data.LevelObjArray
import java.util.logging.Level

class InfinityModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_infinity)

        val playerInfinityInit = findViewById<ImageView>(R.id.player_infinity)
        val buttonReturn = findViewById<Button>(R.id.back_button_infinity)
        val constrain = findViewById<ConstraintLayout>(R.id.screen_infinity)
        val tape = findViewById<ImageView>(R.id.tape_infinity)
        val test = findViewById<TextView>(R.id.testtextinfinity)

        LevelObjArray.setPlayer(playerInfinityInit)
        buttonReturn.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        LevelObjArray.setFirstTape(tape)
        constrain.setOnClickListener(){
            LevelObjArray.changeTape(tape, test)
            LevelObjArray.moveTapeToPlayer(tape)
        }
        LevelObjArray.spawnTape(tape)
        LevelObjArray.moveTapeToSpawn(tape)

    }
    override fun onResume() {
        super.onResume()
//        val tape = findViewById<ImageView>(R.id.tape_infinity)
//        LevelObjArray.moveTapeToPlayer(tape)
    }
}
