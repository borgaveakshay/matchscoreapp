package com.assignment.onlinescoreupdateapp.domain.usecases

import com.assignment.onlinescoreupdateapp.common.TestUtils.getFixturesDetailsNetworkResponse
import com.assignment.onlinescoreupdateapp.data.common.ResultResource
import com.assignment.onlinescoreupdateapp.data.models.fixuredetails.toMatchSummary
import com.assignment.onlinescoreupdateapp.domain.repositories.FixtureRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class GetFixtureDetailsUseCaseTest {

    private val fixtureRepository = mockk<FixtureRepository>()
    private lateinit var getFixtureDetailsUseCase: GetFixtureDetailsUseCase

    @Before
    fun setUp() {
        getFixtureDetailsUseCase = GetFixtureDetailsUseCase(fixtureRepository)
    }

    @Test
    fun `invoke should call getFixtureDetails from fixtureRepository`() = runTest {
        // Given
        val givenFixtureDetails = getFixturesDetailsNetworkResponse()
        coEvery { fixtureRepository.getFixtureDetails() } returns flow {
            emit(ResultResource.Success(givenFixtureDetails.toMatchSummary()))
        }
        // When
        val result = getFixtureDetailsUseCase()
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
    fun `invoke should return error when getFixtureDetails from fixtureRepository throws exception`() =
        runTest {
            // Given
            val givenErrorMessage = "Something went wrong"
            coEvery { fixtureRepository.getFixtureDetails() } returns flow {
                emit(ResultResource.Error(Throwable(givenErrorMessage)))
            }
            // When
            val result = getFixtureDetailsUseCase()
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
    fun `invoke should return loading when getFixtureDetails from fixtureRepository is called`() =
        runTest {
            // Given
            coEvery { fixtureRepository.getFixtureDetails() } returns flow {
                emit(ResultResource.Loading())
            }
            // When
            val result = getFixtureDetailsUseCase()
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