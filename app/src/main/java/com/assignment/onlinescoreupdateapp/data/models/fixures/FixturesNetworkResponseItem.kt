package com.assignment.onlinescoreupdateapp.data.models.fixures


import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem
import com.google.gson.annotations.SerializedName

data class FixturesNetworkResponseItem(
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("clock")
    val clock: Clock,
    @SerializedName("goals")
    val goals: List<Goal>,
    @SerializedName("ground")
    val ground: Ground,
    @SerializedName("id")
    val id: Int,
    @SerializedName("kickoff")
    val kickoff: Kickoff,
    @SerializedName("status")
    val status: String,
    @SerializedName("teams")
    val teams: List<Team>
)

fun FixturesNetworkResponseItem.toFixtureInfoItem(): FixtureInfoItem {
    return FixtureInfoItem(
        id = id,
        attendance = attendance,
        firstTeam = teams[0].toFixtureTeam(),
        secondTeam = teams[1].toFixtureTeam(),
        time = kickoff.label,
        status = status
    )
}