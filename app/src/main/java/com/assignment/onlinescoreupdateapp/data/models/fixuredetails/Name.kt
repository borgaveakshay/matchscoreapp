package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("display")
    val display: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)