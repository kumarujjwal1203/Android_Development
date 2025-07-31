package com.example.creating_navigation_drawer

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
private lateinit var drawerLyout1: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
drawerLyout1=findViewById(R.id.drawerLayout)


        val btn=findViewById<ImageView>(R.id.click)
        btn.setOnClickListener {
            drawerLyout1.open()
        }
    }
}