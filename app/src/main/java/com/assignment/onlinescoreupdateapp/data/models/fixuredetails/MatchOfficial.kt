package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.google.gson.annotations.SerializedName

data class MatchOfficial(
    @SerializedName("birth")
    val birth: Birth,
    @SerializedName("id")
    val id: Int,
    @SerializedName("matchOfficialId")
    val matchOfficialId: Int,
    @SerializedName("name")
    val name: Name,
    @SerializedName("role")
    val role: String
)