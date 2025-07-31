package com.example.rating_bar

import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
val ratingBar=findViewById<RatingBar>(R.id.rating1)
        ratingBar.setOnRatingBarChangeListener{_,rating,_->
            Toast.makeText(this,"You rated $rating stars", Toast.LENGTH_SHORT).show()
        }
    }
}