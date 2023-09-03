package com.example.daggerdependancyinjectiondemo.di

import android.app.Application
import com.example.daggerdependancyinjectiondemo.MyApp
import com.example.daggerdependancyinjectiondemo.domain.repository.MyRepository
import com.example.daggerdependancyinjectiondemo.remote.interfaces.MyApi
import com.example.daggerdependancyinjectiondemo.remote.repository.MyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provide(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)

    }

    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi,app: Application, hello:String): MyRepository {
        return MyRepositoryImpl(api,app)
    }

    @Provides
    @Singleton
    fun provideString1()="Hello"
}