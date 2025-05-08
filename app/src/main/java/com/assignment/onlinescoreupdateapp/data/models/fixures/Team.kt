package com.assignment.onlinescoreupdateapp.data.models.fixures


import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureTeam
import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("score")
    val score: Int,
    @SerializedName("team")
    val team: TeamX
)

fun Team.toFixtureTeam(): FixtureTeam {
    return FixtureTeam(
        id = team.id,
        name = team.name,
        score = score
    )
}