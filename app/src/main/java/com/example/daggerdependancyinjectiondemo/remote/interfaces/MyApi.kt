package com.example.daggerdependancyinjectiondemo.remote.interfaces

import retrofit2.http.GET

interface MyApi {

    @GET("test")
    suspend fun doNetworkCall()
}