/**Created By Nirali Pandya
 * Date :2023-08-27
 * Time :6:03 p.m.
 * Project Name :DaggerDependancyInjectionDemo
 *
 */
package com.example.daggerdependancyinjectiondemo.MyViewModel

import androidx.lifecycle.ViewModel
import com.example.daggerdependancyinjectiondemo.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private  val repository: MyRepository):ViewModel() {

}