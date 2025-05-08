package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class Date(
    @SerializedName("label")
    val label: String,
    @SerializedName("millis")
    val millis: Long
)