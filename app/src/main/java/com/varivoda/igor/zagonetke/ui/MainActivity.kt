package com.varivoda.igor.zagonetke.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.varivoda.igor.zagonetke.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun setActionBarText(text: String){
        supportActionBar?.title = text
    }
}