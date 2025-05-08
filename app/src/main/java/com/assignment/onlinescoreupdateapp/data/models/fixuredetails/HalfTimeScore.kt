package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class HalfTimeScore(
    @SerializedName("awayScore")
    val awayScore: Int,
    @SerializedName("homeScore")
    val homeScore: Int
)