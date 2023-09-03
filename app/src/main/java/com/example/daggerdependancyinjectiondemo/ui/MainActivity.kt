package com.example.daggerdependancyinjectiondemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.daggerdependancyinjectiondemo.R
import com.example.daggerdependancyinjectiondemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()

    }

    private fun setUpView() {

    }

    override fun getViewBinding(inflator: LayoutInflater) =ActivityMainBinding.inflate(inflator)
}