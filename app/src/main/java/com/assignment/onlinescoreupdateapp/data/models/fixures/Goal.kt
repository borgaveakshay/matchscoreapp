package com.assignment.onlinescoreupdateapp.data.models.fixures


import com.google.gson.annotations.SerializedName

data class Goal(
    @SerializedName("assistId")
    val assistId: Int,
    @SerializedName("clock")
    val clock: Clock,
    @SerializedName("description")
    val description: String,
    @SerializedName("personId")
    val personId: Int,
    @SerializedName("phase")
    val phase: String,
    @SerializedName("type")
    val type: String
)