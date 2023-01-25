package com.shino72.exchangecal.data

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("EXCHANGE", Context.MODE_PRIVATE)

    fun getDate() : String {
        return prefs.getString("Date","00000000").toString()
    }
    fun setDate(date : String) {
        prefs.edit().putString("Date", date).apply()
    }
    fun getString(key: String, defValue: String): String {
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }
}