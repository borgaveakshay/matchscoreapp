package com.assignment.onlinescoreupdateapp.data.repositories

import com.assignment.onlinescoreupdateapp.data.apiservices.FixturesApiService
import com.assignment.onlinescoreupdateapp.data.common.ResultResource
import com.assignment.onlinescoreupdateapp.data.models.fixuredetails.toMatchSummary
import com.assignment.onlinescoreupdateapp.data.models.fixures.toFixtureResponse
import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.FixtureResult
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem
import com.assignment.onlinescoreupdateapp.domain.repositories.FixtureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retry

class FixtureRepoImpl(
    private val fixturesApiService: FixturesApiService
) : FixtureRepository {
    override suspend fun getFixtures(): Flow<ResultResource<List<FixtureInfoItem>>> =
        flow<ResultResource<List<FixtureInfoItem>>> {
            fixturesApiService.getFixtures()?.let {
                emit(ResultResource.Success(it.toFixtureResponse()))
            }
        }.onStart {
            emit(ResultResource.Loading())
        }.catch {
            emit(ResultResource.Error(it))
        }

    override suspend fun getFixtureDetails(): Flow<ResultResource<FixtureResult>> =
        flow<ResultResource<FixtureResult>> {
            fixturesApiService.getFixtureDetails()?.let {
                emit(ResultResource.Success(it.toMatchSummary()))
            }
        }.onStart {
            emit(ResultResource.Loading())
        }.catch {
            emit(ResultResource.Error(it))
        }

}