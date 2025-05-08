package com.assignment.onlinescoreupdateapp.domain.models.fixturedetails

data class Player(
    val id: Int,
    val displayName: String,
    val shirtNumber: Int,
    val position: String,
    val matchPosition: String,
    val age: String,
    val isCaptain: Boolean,
    val country: String
)
