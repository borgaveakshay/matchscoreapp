package com.assignment.onlinescoreupdateapp.domain.repositories

import com.assignment.onlinescoreupdateapp.data.common.ResultResource
import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.FixtureResult
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem
import kotlinx.coroutines.flow.Flow

interface FixtureRepository {
    suspend fun getFixtures(): Flow<ResultResource<List<FixtureInfoItem>>>
    suspend fun getFixtureDetails(): Flow<ResultResource<FixtureResult>>
}