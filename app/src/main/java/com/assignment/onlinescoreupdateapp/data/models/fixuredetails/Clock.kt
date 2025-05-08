package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class Clock(
    @SerializedName("label")
    val label: String,
    @SerializedName("secs")
    val secs: Int
)