package com.example.time_picker_dialog


import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPickTime = findViewById<Button>(R.id.btnPickTime)
        val tvSelectedTime = findViewById<TextView>(R.id.tvSelectedTime)

        btnPickTime.setOnClickListener {
            // Step 1: Get current time
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // Step 2: Create TimePickerDialog
            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                val time = String.format("%02d:%02d", selectedHour, selectedMinute)
                tvSelectedTime.text = "Selected Time: $time"
            }, hour, minute, true) // 'true' = 24-hour format

            // Step 3: Show the dialog
            timePickerDialog.show()
        }
    }
}
