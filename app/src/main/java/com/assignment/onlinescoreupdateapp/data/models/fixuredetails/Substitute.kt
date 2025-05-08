package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.Player
import com.google.gson.annotations.SerializedName

data class Substitute(
    @SerializedName("age")
    val age: String,
    @SerializedName("altIds")
    val altIds: AltIds,
    @SerializedName("birth")
    val birth: BirthX,
    @SerializedName("captain")
    val captain: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("info")
    val info: InfoX,
    @SerializedName("matchPosition")
    val matchPosition: String,
    @SerializedName("matchShirtNumber")
    val matchShirtNumber: Int,
    @SerializedName("name")
    val name: NameX,
    @SerializedName("nationalTeam")
    val nationalTeam: NationalTeam,
    @SerializedName("playerId")
    val playerId: Int
)

fun Substitute.toPlayer(): Player {
    return Player(
        id = id,
        displayName = name.display,
        shirtNumber = info.shirtNum,
        position = info.positionInfo,
        matchPosition = matchPosition,
        age = age,
        isCaptain = captain,
        country = nationalTeam.country
    )
}