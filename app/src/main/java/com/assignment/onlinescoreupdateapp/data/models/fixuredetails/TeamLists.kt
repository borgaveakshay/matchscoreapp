package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.TeamLineup
import com.google.gson.annotations.SerializedName

data class TeamLists(
    @SerializedName("formation")
    val formation: Formation,
    @SerializedName("lineup")
    val lineup: List<Lineup>,
    @SerializedName("substitutes")
    val substitutes: List<Substitute>,
    @SerializedName("teamId")
    val teamId: Int
)

fun TeamLists.toTeamLineup(): TeamLineup {
    return TeamLineup(
        teamId = teamId,
        formationLabel = formation.label,
        lineup = lineup.map { it.toPlayer() },
        substitutes = substitutes.map { it.toPlayer() }
    )
}