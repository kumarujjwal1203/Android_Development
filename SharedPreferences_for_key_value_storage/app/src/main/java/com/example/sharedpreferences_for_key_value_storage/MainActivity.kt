package com.example.sharedpreferences_for_key_value_storage


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // Make sure layout file is named this

        // Reference UI elements using findViewById
        val editText = findViewById<EditText>(R.id.edittext1)
        val btnSave = findViewById<Button>(R.id.btn1)
        val btnShow = findViewById<Button>(R.id.btn2)
        val showText = findViewById<TextView>(R.id.shoeText)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("keyvalue", Context.MODE_PRIVATE)

        // Save Button
        btnSave.setOnClickListener {
            val note = editText.text.toString()

            val sharedEdit = sharedPreferences.edit()
            sharedEdit.putString("keyvalue1", note)
            sharedEdit.apply() // Save changes

            editText.text.clear()
        }

        // Show Button
        btnShow.setOnClickListener {
            val storedData = sharedPreferences.getString("keyvalue1", "default")
            showText.text = "$storedData"
        }
    }
}



