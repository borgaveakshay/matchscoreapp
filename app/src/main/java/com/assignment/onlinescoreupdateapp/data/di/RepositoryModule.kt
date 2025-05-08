package com.assignment.onlinescoreupdateapp.data.di

import com.assignment.onlinescoreupdateapp.data.apiservices.FixturesApiService
import com.assignment.onlinescoreupdateapp.data.repositories.FixtureRepoImpl
import com.assignment.onlinescoreupdateapp.domain.repositories.FixtureRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun getFixturesRepository(fixturesApiService: FixturesApiService): FixtureRepository =
        FixtureRepoImpl(fixturesApiService)

}