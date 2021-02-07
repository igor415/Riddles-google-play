package com.varivoda.igor.data

import android.content.SharedPreferences

class Preferences (private val sharedPreferences: SharedPreferences){

    fun getToastTheme(): String{
        return sharedPreferences.getString("toast design","Default") ?: "Default"
    }

    fun setToastTheme(text: String) {
        sharedPreferences.edit().putString("toast design", text).apply()
    }

    fun getVibrationsOption(): Boolean{
        return sharedPreferences.getBoolean("vibrations",true)
    }


}