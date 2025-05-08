package com.assignment.onlinescoreupdateapp.presentation.fixures.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.onlinescoreupdateapp.data.common.ResultResource
import com.assignment.onlinescoreupdateapp.domain.usecases.GetFixturesUseCase
import com.assignment.onlinescoreupdateapp.presentation.fixures.states.FixtureState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureViewModel @Inject constructor(
    private val getFixturesUseCase: GetFixturesUseCase
) : ViewModel() {

    val fixtureStateFlow: StateFlow<FixtureState>
        field = MutableStateFlow(FixtureState())

    fun getFixtures() = viewModelScope.launch {
        getFixturesUseCase().collect { response ->
            when (response) {
                is ResultResource.Error -> {
                    fixtureStateFlow.update {
                        it.copy(
                            isError = true,
                            errorMessage = response.errorMessage ?: "Something went wrong",
                            data = null,
                            isLoading = false
                        )
                    }
                }

                is ResultResource.Loading -> {
                    fixtureStateFlow.update {
                        it.copy(
                            isLoading = true,
                            isError = false,
                            data = null,
                            errorMessage = null
                        )
                    }
                }

                is ResultResource.Success -> {
                    fixtureStateFlow.update {
                        it.copy(
                            data = response.data,
                            isLoading = false,
                            isError = false,
                            errorMessage = null
                        )
                    }
                }
            }
        }
    }
}