/**Created By Nirali Pandya
 * Date :2023-09-02
 * Time :6:57 p.m.
 * Project Name :DaggerDependancyInjectionDemo
 *
 */
package com.example.daggerdependancyinjectiondemo

import android.app.Application
import com.example.daggerdependancyinjectiondemo.prefs.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp:Application() {
    companion object {
        var prefs1: Prefs? = null
        lateinit var instance: MyApp
    }
    override fun onCreate() {
        super.onCreate()
        prefs1 = Prefs(applicationContext)
    }
}