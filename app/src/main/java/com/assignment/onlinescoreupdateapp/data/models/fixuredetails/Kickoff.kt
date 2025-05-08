package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class Kickoff(
    @SerializedName("completeness")
    val completeness: Int,
    @SerializedName("label")
    val label: String,
    @SerializedName("millis")
    val millis: Long
)