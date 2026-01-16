package com.sid.agronear.Api

import android.content.Context
import android.content.SharedPreferences

object TokenManager {

    private const val PREF_NAME = "auth_prefs"
    private const val KEY_ACCESS = "access_token"
    private const val KEY_REFRESH = "refresh_token"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveTokens(access: String, refresh: String) {
        prefs.edit()
            .putString(KEY_ACCESS, access)
            .putString(KEY_REFRESH, refresh)
            .apply()
    }

    fun getAccessToken(): String? {
        return prefs.getString(KEY_ACCESS, null)
    }

    fun getRefreshToken(): String? {
        return prefs.getString(KEY_REFRESH, null)
    }

    fun clear() {
        prefs.edit().clear().apply()
    }
}
