package com.example.action_bar2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the toolbar by its ID
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//
//        // Set the toolbar as the ActionBar
//        setSupportActionBar(toolbar)
//
//        // Optional: Set a title (if not set in the theme)
//        supportActionBar?.title = "My Action Bar"
//    }
//
//    // Inflate the menu items (if any) in the Action Bar
//    override fun onCreateOptionsMenu(menu:Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu,menu)
//        return true
//    }
//
//    // Handle item clicks from the Action Bar
//    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_search -> {
//                // Handle search action
//                true
//            }
//            R.id.action_settings -> {
//                // Handle settings action
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }


        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title="Hello"



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        return when(item.itemId){
            R.id.action_search->{
                true
            }R.id.action_settings->{
                true
            }else->{
                super.onOptionsItemSelected(item)
            }
        }


    }



}
