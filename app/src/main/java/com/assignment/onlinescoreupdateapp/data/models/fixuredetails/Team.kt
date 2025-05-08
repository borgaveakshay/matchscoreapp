package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.TeamScore
import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("score")
    val score: Int,
    @SerializedName("team")
    val team: TeamX
)

