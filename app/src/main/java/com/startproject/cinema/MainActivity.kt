package com.startproject.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.startproject.cinema.FragmentMoviesList

class MainActivity : AppCompatActivity() {

    private val fragmentMoviesList = FragmentMoviesList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.main_container, fragmentMoviesList)
                    addToBackStack(null)
                    commit()
                }
        }

    }
}