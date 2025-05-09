package com.assignment.onlinescoreupdateapp.presentation.fixturedetails.viewmodel

import com.assignment.onlinescoreupdateapp.common.DispatcherRule
import com.assignment.onlinescoreupdateapp.common.TestUtils
import com.assignment.onlinescoreupdateapp.data.common.ResultResource
import com.assignment.onlinescoreupdateapp.data.models.fixuredetails.toMatchSummary
import com.assignment.onlinescoreupdateapp.domain.repositories.FixtureRepository
import com.assignment.onlinescoreupdateapp.domain.usecases.GetFixtureDetailsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class FixtureDetailsViewModelTest {
    @get:Rule
    val dispatcherRule = DispatcherRule()
    private lateinit var viewModel: FixtureDetailsViewModel
    private lateinit var getFixtureDetailsUseCase: GetFixtureDetailsUseCase
    private lateinit var repository: FixtureRepository

    @Before
    fun setup() {
        repository = mockk()
        getFixtureDetailsUseCase = GetFixtureDetailsUseCase(repository)
        viewModel = FixtureDetailsViewModel(getFixtureDetailsUseCase)
    }

    @Test
    fun `test getFixtureDetails success`() = runTest {
        // Given
        val givenFixtureDetailsResponse =
            TestUtils.getFixturesDetailsNetworkResponse().toMatchSummary()
        coEvery { repository.getFixtureDetails() } returns flow {
            emit(ResultResource.Success(givenFixtureDetailsResponse))
        }
        // When
        viewModel.getFixtureDetails(123)
        delay(100)
        // Then
        viewModel.fixtureDetailsStateFlow.value.apply {
            assert(fixtureDetails == givenFixtureDetailsResponse)
        }
    }

    @Test
    fun `test getFixtureDetails error`() = runTest {
        // Given
        val givenErrorMessage = "Something went wrong"
        coEvery { repository.getFixtureDetails() } returns flow {
            emit(ResultResource.Error(Throwable(givenErrorMessage)))
        }
        // When
        viewModel.getFixtureDetails(123)
        delay(100)
        // Then
        viewModel.fixtureDetailsStateFlow.value.apply {
            assert(error == givenErrorMessage)
            assert(fixtureDetails == null)
        }
    }

    @Test
    fun `test getFixtureDetails loading`() = runTest {
        // Given
        coEvery { repository.getFixtureDetails() } returns flow {
            emit(ResultResource.Loading())
        }
        // When
        viewModel.getFixtureDetails(123)
        delay(100)
        // Then
        viewModel.fixtureDetailsStateFlow.value.apply {
            assert(isLoading)
        }
    }

}