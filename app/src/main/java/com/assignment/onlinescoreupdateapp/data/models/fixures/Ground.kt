package com.assignment.onlinescoreupdateapp.data.models.fixures


import com.google.gson.annotations.SerializedName

data class Ground(
    @SerializedName("city")
    val city: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("source")
    val source: String
)