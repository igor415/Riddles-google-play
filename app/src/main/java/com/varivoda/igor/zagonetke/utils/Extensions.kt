package com.varivoda.igor.zagonetke.utils

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.muddzdev.styleabletoast.StyleableToast
import com.varivoda.igor.data.Preferences
import com.varivoda.igor.zagonetke.R

fun Context?.toast(text: String, preferences: Preferences){
    this ?: return
    val id = preferences.getToastTheme().getStyleIdForKey()
    if(id == 0){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }else{
        StyleableToast.makeText(this, text, Toast.LENGTH_LONG, id)
            .show()
    }

}

fun String.getStyleIdForKey(): Int{
    return when(this){
        "Default" -> 0
        "Tamna tema" -> R.style.darkToast
        "Svijetla tema" -> R.style.lightToast
        else -> 0
    }
}

fun Fragment.vibratePhone(value: Long) {
    val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= 26) {
        vibrator.vibrate(VibrationEffect.createOneShot(value, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibrator.vibrate(300)
    }
}