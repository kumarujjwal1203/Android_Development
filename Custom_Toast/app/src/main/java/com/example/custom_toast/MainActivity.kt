package com.example.custom_toast


import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inflate custom toast layou
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast, null)

        val toastTest = layout.findViewById<TextView>(R.id.toast_text)

        toastTest.text = "Hello, My name is Ujjwal"

    val toast= Toast(applicationContext)
        toast.duration=Toast.LENGTH_LONG
        toast.view=layout
        toast.show()
    }
}
