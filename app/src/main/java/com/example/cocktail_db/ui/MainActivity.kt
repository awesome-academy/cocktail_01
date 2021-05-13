package com.example.cocktail_db.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktail_db.R
import com.example.cocktail_db.ui.homepage.HomePageFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.mFragmentMain, HomePageFragment.newInstance())
            .commit()
    }
}
