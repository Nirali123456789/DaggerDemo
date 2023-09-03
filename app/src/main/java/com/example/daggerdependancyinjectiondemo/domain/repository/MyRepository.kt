package com.example.daggerdependancyinjectiondemo.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}