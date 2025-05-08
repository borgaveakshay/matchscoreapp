package com.assignment.onlinescoreupdateapp.data.models.fixures


import com.google.gson.annotations.SerializedName

data class Clock(
    @SerializedName("label")
    val label: String,
    @SerializedName("secs")
    val secs: Int
)