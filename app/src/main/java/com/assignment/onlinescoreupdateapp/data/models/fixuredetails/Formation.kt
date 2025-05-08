package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class Formation(
    @SerializedName("label")
    val label: String,
    @SerializedName("players")
    val players: List<List<Int>>
)