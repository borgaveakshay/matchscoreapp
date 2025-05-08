package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class InfoX(
    @SerializedName("loan")
    val loan: Boolean,
    @SerializedName("position")
    val position: String,
    @SerializedName("positionInfo")
    val positionInfo: String,
    @SerializedName("shirtNum")
    val shirtNum: Int
)