package com.example.implicit_intent


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn1=findViewById<Button>(R.id.btnOpenWeb)
        val btn2=findViewById<Button>(R.id.btndialer)

        btn1.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW)
            intent.data=Uri.parse("https://www.google.org/")
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent1= Intent(Intent.ACTION_DIAL)
            intent1.data= Uri.parse("tel:9155754642")
            startActivity(intent1)
        }



    }
}