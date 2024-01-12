package com.example.daggerdependancyinjectiondemo.prefs

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    companion object {
       const val PRIVACY_POLICY_LINK =
            "https://www.privacypolicycenter.com/view.php?v=cEZEcFc0VTZ5dzdZa244Z1FLeFBRZz09&n=AI-Message"
    }

    private var isPrivacyAccept = "isPrivacyAccepted"
    private var APP_PREF_INT_EXAMPLE = "com.example.daggerdependancyinjectiondemo";

    private val preferences: SharedPreferences =
        context.getSharedPreferences(APP_PREF_INT_EXAMPLE, Context.MODE_PRIVATE)


    var isPrivacyAccepted: Boolean
        get() = preferences.getBoolean(isPrivacyAccept, false)
        set(value) = preferences.edit().putBoolean(isPrivacyAccept, value).apply()
}