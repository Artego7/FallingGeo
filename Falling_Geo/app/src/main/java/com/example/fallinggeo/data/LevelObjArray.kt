package com.example.fallinggeo.data

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.fallinggeo.R
import kotlin.random.Random


object LevelObjArray: ArrayList<Player>() {
    init{
        add(Player(0,"Triangulo", R.drawable.g_triangle))
        add(Player(1,"Cuadrado", R.drawable.g_square))
        add(Player(2,"Circulo", R.drawable.g_circle))
        add(Player(3,"Rombo", R.drawable.g_rhombus))
    }
    val geometryTape = listOf(
        R.drawable.tape_circle,
        R.drawable.tape_square,
        R.drawable.tape_triangle,
        R.drawable.tape_rhombus
    )

    private fun randomPlayerInit(): Int {
        return Random.nextInt(0,3)
    }

    fun CheckifPass(idColl: Int, idPlayer: Int): Boolean {
        return idColl == idPlayer
    }

    fun setPlayer(PlayerImg: ImageView): ImageView {
        val index = randomPlayerInit()
        PlayerImg.id = LevelObjArray[index].id
        PlayerImg.setImageResource(LevelObjArray[index].image)
        return PlayerImg
    }

    //------------------ Tape part ------------------//
    fun setFirstTape(tape: ImageView): ImageView{
        tape.id = Random.nextInt(0,3)
        tape.setImageResource(geometryTape[tape.id])
        return tape
    }
    fun changeTape(tape:ImageView, test: TextView): ImageView{
//        tape.setImageResource(geometryTape.iterator().next())
        val temp = tape.id
        if(tape.id >= 3){
            tape.setImageResource(geometryTape[0])
            tape.id = 0
            test.text = "NO"
        }
        else {
            tape.setImageResource(geometryTape[tape.id+1])
            tape.id = temp+1
            test.text = "Geometry Tape: "+geometryTape[tape.id].toString() +
                    "    id: " +tape.id
        }
        return tape
    }
    fun spawnTape(tape:ImageView): ImageView{
        tape.y = -199f
        return tape
    }
    fun moveTapeToSpawn(tape:ImageView): ImageView{
        if (tape.y <= -200f){
            tape.y = 1600f
        }
        return tape
    }
    fun moveTapeToPlayer(tape:ImageView): ImageView{
        tape.y += -1f
        return tape
    }
}