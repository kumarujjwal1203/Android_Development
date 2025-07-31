package com.example.internal_storage_for_private_app_data_reading_and_writing_files

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.*

class MainActivity : AppCompatActivity() {

    private val fileName = "note.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edittext1)
        val btnSave = findViewById<Button>(R.id.btn1)
        val btnRead = findViewById<Button>(R.id.btn2)
        val btnDelete = findViewById<Button>(R.id.btn3)
        val textView = findViewById<TextView>(R.id.showText)

        // Save data
        btnSave.setOnClickListener {
            val textToSave = editText.text.toString()

                openFileOutput(fileName, MODE_PRIVATE).use {
                    it.write(textToSave.toByteArray())

                editText.text.clear()
                textView.text = "Saved to $fileName"
            }
        }

        // Read data
        btnRead.setOnClickListener {

                val fileInput = openFileInput(fileName)
                val text = fileInput.bufferedReader().readText()
                textView.text = text

        }

        // Delete file
        btnDelete.setOnClickListener {
            val deleted = deleteFile(fileName)
            textView.text = if (deleted) "File deleted" else "File not found"
        }
    }
}
