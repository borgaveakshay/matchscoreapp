package com.assignment.onlinescoreupdateapp.domain.models.fixturedetails

data class TeamLineup(
    val teamId: Int,
    val formationLabel: String,
    val lineup: List<Player>,
    val substitutes: List<Player>
)
