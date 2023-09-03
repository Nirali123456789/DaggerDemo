/**Created By Nirali Pandya
 * Date :2023-08-22
 * Time :7:51 p.m.
 * Project Name :DaggerDependancyInjectionDemo
 *
 */
package com.example.daggerdependancyinjectiondemo.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {
    private var _binding: B? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding(layoutInflater)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            window.statusBarColor = Color.BLACK
        }
        setContentView(binding.root)
    }

    abstract fun getViewBinding(inflator: LayoutInflater): B

}