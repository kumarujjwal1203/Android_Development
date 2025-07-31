package com.example.creating_swipe_views_with_tabs

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewPager=findViewById(R.id.viewPager)
        tabLayout=findViewById(R.id.tabLayout)

        val adapter= ViewPagerAdapter(this)

        viewPager.adapter=adapter

        val tabTitles=arrayOf("First","Second","Third")

        TabLayoutMediator(tabLayout,viewPager){
            tab,position->
            tab.text=tabTitles[position]
        }.attach()

    }
}