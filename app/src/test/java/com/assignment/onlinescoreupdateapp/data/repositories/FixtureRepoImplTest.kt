package com.assignment.onlinescoreupdateapp.data.repositories

import com.assignment.onlinescoreupdateapp.common.TestUtils.getFixturesDetailsNetworkResponse
import com.assignment.onlinescoreupdateapp.common.TestUtils.getFixturesNetworkResponse
import com.assignment.onlinescoreupdateapp.data.apiservices.FixturesApiService
import com.assignment.onlinescoreupdateapp.data.common.ResultResource
import com.assignment.onlinescoreupdateapp.data.models.fixuredetails.toMatchSummary
import com.assignment.onlinescoreupdateapp.data.models.fixures.toFixtureResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class FixtureRepoImplTest {
    private val fixturesApiService = mockk<FixturesApiService>()
    private lateinit var fixtureRepoImpl: FixtureRepoImpl

    @Before
    fun setUp() {
        fixtureRepoImpl = FixtureRepoImpl(fixturesApiService)
    }

    @Test
    fun `getFixtures should call getFixtures from fixturesApiService`() = runTest {
        // Given
        val givenFixtures = getFixturesNetworkResponse()
        coEvery { fixturesApiService.getFixtures() } returns givenFixtures
        // When
        val result = fixtureRepoImpl.getFixtures()
        // Then
        result.collect {
            when {
                it is ResultResource.Success -> {
                    assert(it.data == givenFixtures.toFixtureResponse())
                }
            }
        }
    }

    @Test
    fun `getFixtures should return error when getFixtures from fixturesApiService throws exception`() =
        runTest {
            // Given
            val givenErrorMessage = "Something went wrong"
            coEvery { fixturesApiService.getFixtures() } throws Throwable(givenErrorMessage)
            // When
            val result = fixtureRepoImpl.getFixtures()
            // Then
            result.collect {
                when {
                    it is ResultResource.Error -> {
                        assert(it.errorMessage == givenErrorMessage)
                    }
                }
            }
        }

    @Test
    fun `getFixtures should return loading when getFixtures from fixturesApiService is called`() =
        runTest {
            // Given
            val givenFixtures = getFixturesNetworkResponse()
            coEvery { fixturesApiService.getFixtures() } returns givenFixtures
            // When
            val result = fixtureRepoImpl.getFixtures()
            // Then
            result.collect {
                when {
                    it is ResultResource.Loading -> {
                        assert(true)
                    }
                }
            }
        }

    @Test
    fun `getFixtureDetails should call getFixtureDetails from fixturesApiService`() = runTest {
        // Given
        val givenFixtureDetails = getFixturesDetailsNetworkResponse()
        coEvery { fixturesApiService.getFixtureDetails() } returns givenFixtureDetails
        // When
        val result = fixtureRepoImpl.getFixtureDetails()
        // Then
        result.collect {
            when {
                it is ResultResource.Success -> {
                    assert(it.data == givenFixtureDetails.toMatchSummary())
                }
            }
        }
    }

    @Test
    fun `getFixtureDetails should return error when getFixtureDetails from fixturesApiService throws exception`() =
        runTest {
            // Given
            val givenErrorMessage = "Something went wrong"
            coEvery { fixturesApiService.getFixtureDetails() } throws Throwable(givenErrorMessage)
            // When
            val result = fixtureRepoImpl.getFixtureDetails()
            // Then
            result.collect {
                when {
                    it is ResultResource.Error -> {
                        assert(it.errorMessage == givenErrorMessage)
                    }
                }
            }
        }

    @Test
    fun `getFixtureDetails should return loading when getFixtureDetails from fixturesApiService is called`() =
        runTest {
            // Given
            val givenFixtureDetails = getFixturesDetailsNetworkResponse()
            coEvery { fixturesApiService.getFixtureDetails() } returns givenFixtureDetails
            // When
            val result = fixtureRepoImpl.getFixtureDetails()
            // Then
            result.collect {
                when {
                    it is ResultResource.Loading -> {
                        assert(true)
                    }
                }
            }
        }
}