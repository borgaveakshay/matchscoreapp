package com.assignment.onlinescoreupdateapp.data.models.fixures

import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem


class FixturesNetworkResponse : ArrayList<FixturesNetworkResponseItem>()

fun FixturesNetworkResponse.toFixtureResponse(): List<FixtureInfoItem> {
    val fixtureList = mutableListOf<FixtureInfoItem>()
    this.map { fixture ->
        fixtureList.add(fixture.toFixtureInfoItem())
    }
    return fixtureList
}