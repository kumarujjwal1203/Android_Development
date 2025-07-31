package com.example.external_storage_for_shareddata

import android.content.ContentValues
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.OutputStream
import androidx.activity.enableEdgeToEdge
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Link the EditText and Button from the XML layout
        val nameInput = findViewById<EditText>(R.id.txtName)
        val passInput = findViewById<EditText>(R.id.txtPwd)
        val saveButton = findViewById<Button>(R.id.btnSave)

        // When button is clicked
        saveButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val password = passInput.text.toString().trim()

            // Check if fields are empty
            if (name.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Combine the data into one string
            val fileData = "Username: $name\nPassword: $password"

            // Save the data into Downloads folder
            val fileName = "UserDetails.txt"
            val success = saveToDownloads(fileName, fileData)

            if (success) {
                Toast.makeText(this, "Saved to Downloads!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Failed to save!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // This function saves text into the Downloads folder using MediaStore
    private fun saveToDownloads(fileName: String, fileContent: String): Boolean {
        return try {
            // Set file info
            val contentValues = ContentValues().apply {
                put(MediaStore.Downloads.DISPLAY_NAME, fileName)      // File name
                put(MediaStore.Downloads.MIME_TYPE, "text/plain")     // File type
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    put(MediaStore.Downloads.RELATIVE_PATH, "Download/") // Save in Downloads folder
                }
            }

            // Create new file entry in MediaStore
            val resolver = contentResolver
            val fileUri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)

            // Write content into the file
            fileUri?.let {
                val outputStream: OutputStream? = resolver.openOutputStream(it)
                outputStream?.use {
                    it.write(fileContent.toByteArray()) // Write text to file
                    it.flush()
                }
                true // Success
            } ?: false // Failed to create file
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}