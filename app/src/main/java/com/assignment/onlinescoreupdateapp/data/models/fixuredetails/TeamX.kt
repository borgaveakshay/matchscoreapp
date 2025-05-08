package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.TeamScore
import com.google.gson.annotations.SerializedName

data class TeamX(
    @SerializedName("altIds")
    val altIds: AltIds,
    @SerializedName("club")
    val club: Club,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("teamType")
    val teamType: String
)

fun TeamX.toTeamScore(): TeamScore {
    return TeamScore(
        name = name,
        abbr = club.abbr
    )
}