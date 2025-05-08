package com.assignment.onlinescoreupdateapp.presentation.fixturedetails.states

import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.FixtureResult

data class FixtureDetailsState(
    val isLoading: Boolean = false,
    val fixtureDetails: FixtureResult? = null,
    val error: String? = null
)