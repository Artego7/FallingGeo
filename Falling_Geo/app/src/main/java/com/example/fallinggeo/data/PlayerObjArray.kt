package com.example.fallinggeo.data

import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import com.example.fallinggeo.R
import kotlin.random.Random


object PlayerObjArray: ArrayList<Player>() {
    init{
        add(Player(0,"Circulo", R.drawable.g_circle, 0))
        add(Player(1,"Cuadrado", R.drawable.g_square,0))
        add(Player(2,"Triangulo", R.drawable.g_triangle,0))
        add(Player(3,"Rombo", R.drawable.g_rhombus,0))
    }
    private val geometryTape = listOf(
        R.drawable.tape_circle,
        R.drawable.tape_square,
        R.drawable.tape_triangle,
        R.drawable.tape_rhombus
    )
    //-- Booleans --//
    var isPlaying = true
    var isPass = true

    var tapeSpeed = 4f

    private fun randomPlayerInit(): Int {
        return Random.nextInt(0,3)
    }

    fun setPlayer(PlayerImg: ImageView, points: TextView): ImageView {
        val index = randomPlayerInit()
        PlayerImg.setImageResource(PlayerObjArray[index].image)
        PlayerImg.id = PlayerObjArray[index].id
        points.text = PlayerObjArray[index].points.toString()
        isPlaying = true
        return PlayerImg
    }

    //------------------ Tape part ------------------//
    fun setSpawnTape(tape: ImageView,  screen: DisplayMetrics): ImageView{
        val idInit = randomTapeInit()
        tape.setImageResource(geometryTape[idInit])
        tape.id = idInit
        tape.y = screen.heightPixels.toFloat()-100f
        isPass = true
        return tape
    }
    private fun randomTapeInit(): Int {
        return Random.nextInt(0,3)
    }
    fun changeTape(tape:ImageView): ImageView{
        val temp = tape.id
        if(tape.id >= 3){
            tape.setImageResource(geometryTape[0])
            tape.id = 0
        }
        else {
            tape.setImageResource(geometryTape[tape.id+1])
            tape.id = temp+1
        }
        return tape
    }
    fun moveTapeToSpawn(tape:ImageView, screen: DisplayMetrics, points: TextView): ImageView{
        if (tape.y <= 10f){
            setSpawnTape(tape, screen)
        }
        if((points.text.last().toInt() == 0 || points.text.last().toInt() == 5)
            && points.text != "0"){
            tapeSpeed += 4f
        }
        return tape
    }
    private fun moveTapeUp(tape:ImageView, bool: Boolean): ImageView{
        if(bool) {
            tape.y -= tapeSpeed
        }
        return tape
    }
    private fun checkColl(tape: ImageView, player: ImageView): Boolean{
        return tape.y <= player.y+player.height && tape.y+tape.height >= player.y
    }
    private fun checkId(tape: ImageView, player: ImageView): Boolean{
        return tape.id == player.id
    }
    private fun addPoints(points: TextView): TextView{
        val temp = points.text.toString().toInt()+1
        points.text = temp.toString()
        return points
    }
    private fun checkPassPlayer(tape: ImageView, player: ImageView): Boolean {
        return tape.y+tape.height <= player.y
    }
    fun restartGame(tape: ImageView, screen: DisplayMetrics, points: TextView) {
        setSpawnTape(tape, screen)
        points.text = "0"
        tapeSpeed = 4f
        isPlaying = true
    }
    private fun startGameOverMenu(layerMenu: ImageView, pauseRestartText: TextView,
                                  buttonRestart: ImageView, buttonReturn: Button) {
        layerMenu.visibility = View.VISIBLE
        pauseRestartText.visibility = View.VISIBLE
        buttonRestart.visibility = View.VISIBLE
        buttonReturn.visibility = View.VISIBLE
        pauseRestartText.text = "Game Over"
    }

    fun update(tape: ImageView, player: ImageView, points:TextView,
               layerMenu : ImageView, pauseRestartText: TextView,
               buttonRestart: ImageView, buttonReturn: Button,
               screen: DisplayMetrics){
        moveTapeUp(tape, isPlaying)
        if(checkColl(tape,player)){
            if(!checkId(tape, player)){
                isPlaying = false
                startGameOverMenu(layerMenu, pauseRestartText, buttonRestart,
                    buttonReturn)
            }
        }
        if(checkPassPlayer(tape, player)){
            if(isPass){
                isPass = false
                addPoints(points)
            }
        }
        moveTapeToSpawn(tape, screen, points)
    }


}