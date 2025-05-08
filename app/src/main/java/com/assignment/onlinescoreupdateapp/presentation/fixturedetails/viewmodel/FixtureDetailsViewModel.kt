package com.assignment.onlinescoreupdateapp.presentation.fixturedetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.onlinescoreupdateapp.data.common.ResultResource
import com.assignment.onlinescoreupdateapp.domain.usecases.GetFixtureDetailsUseCase
import com.assignment.onlinescoreupdateapp.presentation.fixturedetails.states.FixtureDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureDetailsViewModel @Inject constructor(
    private val getFixtureDetailsUseCase: GetFixtureDetailsUseCase
) : ViewModel() {

    val fixtureDetailsStateFlow: StateFlow<FixtureDetailsState>
        field = MutableStateFlow(FixtureDetailsState())

    fun getFixtureDetails(fixtureId: Int) {
        viewModelScope.launch {
            getFixtureDetailsUseCase().collect { response ->
                when (response) {
                    is ResultResource.Error -> {
                        fixtureDetailsStateFlow.update {
                            it.copy(
                                isLoading = false,
                                error = response.errorMessage,
                                fixtureDetails = null
                            )
                        }
                    }

                    is ResultResource.Loading -> {
                        fixtureDetailsStateFlow.update {
                            it.copy(
                                isLoading = true,
                                error = null,
                                fixtureDetails = null
                            )
                        }
                    }

                    is ResultResource.Success -> {
                        fixtureDetailsStateFlow.update {
                            it.copy(
                                isLoading = false,
                                error = null,
                                fixtureDetails = response.data
                            )
                        }
                    }
                }
            }
        }
    }
}