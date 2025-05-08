package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class BirthX(
    @SerializedName("country")
    val country: Country,
    @SerializedName("date")
    val date: Date,
    @SerializedName("place")
    val place: String
)