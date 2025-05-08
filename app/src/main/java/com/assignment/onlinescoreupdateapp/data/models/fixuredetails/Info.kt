package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("position")
    val position: String,
    @SerializedName("positionInfo")
    val positionInfo: String,
    @SerializedName("shirtNum")
    val shirtNum: Int
)