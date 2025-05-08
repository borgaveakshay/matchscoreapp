package com.assignment.onlinescoreupdateapp.data.di

import com.assignment.achmeaassignment.BuildConfig
import com.assignment.onlinescoreupdateapp.data.apiservices.FixturesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getFixturesApiService(retrofit: Retrofit): FixturesApiService =
        retrofit.create(FixturesApiService::class.java)

}