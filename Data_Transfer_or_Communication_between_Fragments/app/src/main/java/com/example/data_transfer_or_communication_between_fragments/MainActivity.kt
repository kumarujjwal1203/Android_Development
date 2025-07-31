package com.example.data_transfer_or_communication_between_fragments


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentA.FragmentAListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Show FragmentA when app starts
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentA())
            .commit()
    }

    // This method is triggered by FragmentA
    override fun onDataSend(input: String) {
        val fragmentB = FragmentB()

        // Bundle = used to pass data
        val bundle = Bundle()
        bundle.putString("user_input", input)
        fragmentB.arguments = bundle

        // Show FragmentB and pass the data
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentB)
            .addToBackStack(null)
            .commit()
    }
}
