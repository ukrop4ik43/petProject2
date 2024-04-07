package com.pettpro.data.repository.splashstorage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.pettpro.domain.splashstorage.SplashStorage
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import java.util.prefs.Preferences

class SplashStorageImpl(val context: Context):SplashStorage {
    private val PREF_NAME = "MyPreferences"
    private val KEY_BOOLEAN_VALUE = "booleanValue"


    override  fun saveOnBoardingState(completed: Boolean) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putBoolean(KEY_BOOLEAN_VALUE, completed)
            apply()
        }
    }

    override fun readOnBoardingState(): Boolean{
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(KEY_BOOLEAN_VALUE, false)
    }
}