package com.spcomes.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import com.spcomes.R
import com.spcomes.databinding.ActivityGameBinding

class Game : AppCompatActivity() {
    var roll= mutableListOf<String>("1","2","3")
    lateinit var im1:ImageView
    lateinit var im2:ImageView
    lateinit var im3:ImageView
    lateinit var im4:ImageView
    lateinit var score:TextView
    var r1="0"
    var r2="0"
    var r3="0"
    var r4="0"
    var scr=0
    private var timer: CountDownTimer?=null
    lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        im1=findViewById(R.id.im1)
        im2=findViewById(R.id.im2)
        im3=findViewById(R.id.im3)
        im4=findViewById(R.id.im4)
        score=findViewById(R.id.scoret)
        r4=roll.random()
        check(r4,im4)
        im1.setOnClickListener {
            r1=roll.random()
            check(r1,im1)
            checkforWin(r1,r4)
            startTimer(500)
        }
        im2.setOnClickListener {
            r2=roll.random()
            check(r2,im2)
            checkforWin(r2,r4)
            startTimer(500)
        }
        im3.setOnClickListener {
            r3=roll.random()
            check(r3,im3)
            checkforWin(r3,r4)
            startTimer(500)

        }



    }

    private fun startTimer(timeMillis:Long){
        timer?.cancel()
        timer=object : CountDownTimer(timeMillis,500){

            override fun onTick(TimeEl: Long) {


            }
            override fun onFinish() {
                im3.setImageResource(R.drawable.box)
                im2.setImageResource(R.drawable.box)
                im1.setImageResource(R.drawable.box)
                r4=roll.random()
                check(r4,im4)
            }

        }.start()

    }

    fun check(i:String,im:ImageView){
        if(i=="1"){
            im.setImageResource(R.drawable.wolf)
        }else if(i=="2"){
            im.setImageResource(R.drawable.moon)
        }else{
            im.setImageResource(R.drawable.book)
        }
    }
    fun checkforWin(i:String,i1:String){
        if(i=="1"&&i1=="1"){
            scr++
            score.text="$scr"
        }else if(i=="2"&& i1=="2"){
            scr++
            score.text="$scr"
        }else if(i=="3"&&i1=="3"){
            scr++
            score.text="$scr"
        }
    }


}