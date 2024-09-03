package com.example.diceroller

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val s1=findViewById<TextView>(R.id.Roll)
        s1.setOnClickListener{
    Toast.makeText(this,"Dice Rolled",Toast.LENGTH_SHORT).show()
            rollDice()


    }


}

    private fun rollDice() {
        val s2=findViewById<TextView>(R.id.TextView)
        val randomNumber=Random.nextInt(6)+1
        val s3= when(randomNumber){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        }
        val discImage=findViewById<ImageView>(R.id.Diceroller)
        discImage.setImageResource(s3)
        s2.text=randomNumber.toString()
    }
    }
