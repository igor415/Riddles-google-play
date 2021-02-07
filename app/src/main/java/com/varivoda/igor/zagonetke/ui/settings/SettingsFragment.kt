package com.varivoda.igor.zagonetke.ui.settings

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.varivoda.igor.data.Preferences
import com.varivoda.igor.zagonetke.R
import com.varivoda.igor.zagonetke.ui.MainActivity
import com.varivoda.igor.zagonetke.utils.toast
import org.koin.android.ext.android.inject

class SettingsFragment: PreferenceFragmentCompat() {

    private val preferences: Preferences by inject()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)

        ((activity) as MainActivity).supportActionBar?.title = getString(R.string.settings)

        findPreference<ListPreference>("toast design")?.setOnPreferenceChangeListener { _, value ->
            preferences.setToastTheme(value as String)
            context?.toast(getString(R.string.toast_theme_changed),preferences)
            return@setOnPreferenceChangeListener true
        }
    }


}