package com.assignment.onlinescoreupdateapp.presentation.fixures.states

import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem

data class FixtureState(
    val isLoading: Boolean = false,
    val data: List<FixtureInfoItem>? = null,
    val isError: Boolean = false,
    val errorMessage: String? = null
)
