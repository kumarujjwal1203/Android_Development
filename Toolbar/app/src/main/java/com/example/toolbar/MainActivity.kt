package com.example.toolbar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import  android.view.Menu


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar1 = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar1)

    }

    override fun onCreateOptionsMenu(menu:Menu?): Boolean{
        menuInflater.inflate(R.menu.menu_main,menu)
        return  true;
    }
}