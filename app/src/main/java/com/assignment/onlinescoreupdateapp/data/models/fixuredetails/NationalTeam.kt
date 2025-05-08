package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class NationalTeam(
    @SerializedName("country")
    val country: String,
    @SerializedName("demonym")
    val demonym: String,
    @SerializedName("isoCode")
    val isoCode: String
)