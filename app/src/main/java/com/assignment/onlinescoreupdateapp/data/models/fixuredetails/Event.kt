package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.MatchEvent
import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("assistId")
    val assistId: Int,
    @SerializedName("clock")
    val clock: Clock,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("personId")
    val personId: Int,
    @SerializedName("phase")
    val phase: String,
    @SerializedName("score")
    val score: Score,
    @SerializedName("teamId")
    val teamId: Int,
    @SerializedName("time")
    val time: Time,
    @SerializedName("type")
    val type: String
)

fun Event.toMatchEvent(teamLists: List<TeamLists>, teams: List<Team>): MatchEvent {

    return MatchEvent(
        minute = time.label,
        scorerName = teamLists.first { it.teamId == teamId }.lineup.firstOrNull { it.playerId == personId }?.name?.display
            ?: "Unknown",
        teamAbbr = teams.first { it.team.id == teamId }.team.toTeamScore().abbr,
        isOwnGoal = type == "OG",
        isPenalty = type == "P"
    )
}