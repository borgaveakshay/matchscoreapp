package com.assignment.onlinescoreupdateapp.data.apiservices

import com.assignment.onlinescoreupdateapp.data.models.fixuredetails.FixtureDetailsNetworkResponse
import com.assignment.onlinescoreupdateapp.data.models.fixures.FixturesNetworkResponse
import retrofit2.http.GET

interface FixturesApiService {
    @GET("fixtures.json")
    suspend fun getFixtures(): FixturesNetworkResponse?

    @GET("match.json")
    suspend fun getFixtureDetails(): FixtureDetailsNetworkResponse?

}