/**Created By Nirali Pandya
 * Date :2023-08-27
 * Time :5:27 p.m.
 * Project Name :DaggerDependancyInjectionDemo
 *
 */
package com.example.daggerdependancyinjectiondemo.remote.repository

import android.app.Application
import com.example.daggerdependancyinjectiondemo.R
import com.example.daggerdependancyinjectiondemo.domain.repository.MyRepository
import com.example.daggerdependancyinjectiondemo.remote.interfaces.MyApi

class MyRepositoryImpl(private val MyApi: MyApi,
    private val appContext:Application
) : MyRepository {
    init {
        val appName=appContext.getString(R.string.app_name)
        println("Helooo  $appName")
    }

    override suspend fun doNetworkCall() {

    }
}