package com.assignment.onlinescoreupdateapp.domain.models.fixtures

data class FixtureInfoItem(
    val id: Int,
    val attendance: Int,
    val firstTeam: FixtureTeam,
    val secondTeam: FixtureTeam,
    val time: String,
    val status: String
)
