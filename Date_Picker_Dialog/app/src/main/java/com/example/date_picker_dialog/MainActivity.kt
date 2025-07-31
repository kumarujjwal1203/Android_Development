package com.example.date_picker_dialog

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPickDate = findViewById<Button>(R.id.btnPickDate)
        val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)

        btnPickDate.setOnClickListener {
            // Step 1: Get current date
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Step 2: Create DatePickerDialog
            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                // Note: Months are 0-indexed (January = 0)
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate.text = "Selected Date: $date"
            }, year, month, day)

            // Step 3: Show the dialog
            datePickerDialog.show()
        }
    }
}
