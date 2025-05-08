package com.assignment.onlinescoreupdateapp.domain.models.fixturedetails

data class FixtureResult(
    val homeTeam: TeamScore,
    val awayTeam: TeamScore,
    val fullTimeScore: String,
    val halfTimeScore: String,
    val events: List<MatchEvent>,
    val kickOffTime: String,
    val matchDate: String,
    val stadium: String,
    val attendance: String,
    val referee: String
)