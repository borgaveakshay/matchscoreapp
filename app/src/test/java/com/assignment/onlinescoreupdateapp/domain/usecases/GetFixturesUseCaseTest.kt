package com.assignment.onlinescoreupdateapp.domain.usecases

import com.assignment.onlinescoreupdateapp.common.TestUtils.getFixtures
import com.assignment.onlinescoreupdateapp.data.common.ResultResource
import com.assignment.onlinescoreupdateapp.domain.repositories.FixtureRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class GetFixturesUseCaseTest {

    private val repository = mockk<FixtureRepository>()
    private lateinit var getFixturesUseCase: GetFixturesUseCase

    @Before
    fun setUp() {
        getFixturesUseCase = GetFixturesUseCase(repository)
    }

    @Test
    fun `invoke should call getFixtures from repository`() = runTest {
        // Given
        val givenFixtures = getFixtures()
        coEvery { repository.getFixtures() } returns flowOf(
            ResultResource.Success(
                givenFixtures
            )
        )

        // When
        val result = getFixturesUseCase()
        // Then
        result.collect {
            assert(it is ResultResource.Success)
            assert(it.data == givenFixtures)
        }
    }

    @Test
    fun `invoke should return error when repository throws exception`() = runTest {
        // Given
        val errorMessage = "Something went wrong"
        coEvery { repository.getFixtures() } returns flowOf(
            ResultResource.Error(
                Throwable(errorMessage)
            )
        )
        // When
        val result = getFixturesUseCase()
        // Then
        result.collect {
            assert(it is ResultResource.Error)
            assert(it.errorMessage == errorMessage)
        }
    }

    @Test
    fun `invoke should return loading when repository emits loading`() = runTest {
        // Given
        coEvery { repository.getFixtures() } returns flowOf(
            ResultResource.Loading()
        )
        // When
        val result = getFixturesUseCase()
        // Then
        result.collect {
            assert(it is ResultResource.Loading)
        }
    }


}