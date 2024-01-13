package com.example.daggerdependancyinjectiondemo.service

import javax.inject.Inject

class UserService @Inject constructor() {
    fun getUser(): String {
        return "Simple Demo of Hilt-Dependency Injection.."
    }
}
