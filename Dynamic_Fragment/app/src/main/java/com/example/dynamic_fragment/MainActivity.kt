package com.example.dynamic_fragment


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Step 1: Create an instance of the fragment
        val fragment = MyFragment()

        // Step 2: Get the FragmentManager
        val fragmentManager: FragmentManager = supportFragmentManager

        // Step 3: Begin the transaction
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Step 4: Add the fragment to container
        fragmentTransaction.add(R.id.fragment_container, fragment)

        // Step 5: Commit the transaction
        fragmentTransaction.commit()
    }
}
