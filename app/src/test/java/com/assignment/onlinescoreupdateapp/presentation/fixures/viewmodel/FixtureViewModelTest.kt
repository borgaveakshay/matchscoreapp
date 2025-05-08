package com.assignment.onlinescoreupdateapp.presentation.fixures.viewmodel

import com.assignment.onlinescoreupdateapp.common.DispatcherRule
import com.assignment.onlinescoreupdateapp.common.TestUtils
import com.assignment.onlinescoreupdateapp.data.common.ResultResource
import com.assignment.onlinescoreupdateapp.data.models.fixures.toFixtureResponse
import com.assignment.onlinescoreupdateapp.domain.repositories.FixtureRepository
import com.assignment.onlinescoreupdateapp.domain.usecases.GetFixturesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class FixtureViewModelTest {

    @get:Rule
    val dispatcherRule = DispatcherRule()

    private lateinit var viewModel: FixtureViewModel
    private lateinit var getFixturesUseCase: GetFixturesUseCase
    private lateinit var repository: FixtureRepository

    @Before
    fun setup() {
        repository = mockk()
        getFixturesUseCase = GetFixturesUseCase(repository)
        viewModel = FixtureViewModel(getFixturesUseCase)
    }

    @Test
    fun `test getFixtures success`() = runTest {
        // Given
        val givenFixturesResponse = TestUtils.getFixturesNetworkResponse().toFixtureResponse()
        coEvery { repository.getFixtures() } returns flow {
            emit(ResultResource.Success(givenFixturesResponse))
        }
        // When
        viewModel.getFixtures()
        delay(100)
        // Then
        viewModel.fixtureStateFlow.value.apply {
            assert(data == givenFixturesResponse)
        }
    }

    @Test
    fun `test getFixtures error`() = runTest {
        // Given
        val givenErrorMessage = "Something went wrong"
        coEvery { repository.getFixtures() } returns flow {
            emit(ResultResource.Error(Throwable(givenErrorMessage)))
        }
        // When
        viewModel.getFixtures()
        delay(100)
        // Then
        viewModel.fixtureStateFlow.value.apply {
            assert(errorMessage == givenErrorMessage)
        }
    }

    @Test
    fun `test getFixtures loading`() = runTest {
        // Given
        coEvery { repository.getFixtures() } returns flow {
            emit(ResultResource.Loading())
        }
        // When
        viewModel.getFixtures()
        delay(100)
        // Then
        viewModel.fixtureStateFlow.value.apply {
            assert(isLoading)
        }
    }
}