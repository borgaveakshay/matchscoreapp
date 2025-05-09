package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.FixtureResult
import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.MatchEvent
import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.Player
import com.google.gson.annotations.SerializedName

data class FixtureDetailsNetworkResponse(
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("clock")
    val clock: Clock,
    @SerializedName("events")
    val events: List<Event>,
    @SerializedName("ground")
    val ground: Ground,
    @SerializedName("halfTimeScore")
    val halfTimeScore: HalfTimeScore,
    @SerializedName("id")
    val id: Int,
    @SerializedName("kickoff")
    val kickoff: Kickoff,
    @SerializedName("matchOfficials")
    val matchOfficials: List<MatchOfficial>,
    @SerializedName("status")
    val status: String,
    @SerializedName("teamLists")
    val teamLists: List<TeamLists>,
    @SerializedName("teams")
    val teams: List<Team>
)

fun FixtureDetailsNetworkResponse.toMatchSummary(): FixtureResult {
    val home = teams[0]
    val away = teams[1]

    val homeTeam = home.team.toTeamScore()

    val awayTeam = away.team.toTeamScore()

    val fullTimeScore = "${home.score} - ${away.score}"
    val halfTimeScore = "HT ${halfTimeScore.homeScore} - ${halfTimeScore.awayScore}"

    val matchEvents = events.filter { it.description == "G" }.map { event ->
        val scorerName = findPlayerName(event.personId)
        val teamShort =
            teams.firstOrNull { team -> team.team.id == event.teamId }?.team?.club?.abbr ?: "UNK"
        MatchEvent(
            minute = event.clock.label,
            scorerName = scorerName,
            teamAbbr = teamShort,
            isOwnGoal = false,
            isPenalty = false
        )
    }

    val mainReferee = matchOfficials.firstOrNull { it.role == "MAIN" }?.name?.display ?: "Unknown"

    return FixtureResult(
        homeTeam = homeTeam,
        awayTeam = awayTeam,
        fullTimeScore = fullTimeScore,
        halfTimeScore = halfTimeScore,
        events = matchEvents,
        kickOffTime = kickoff.label.substringAfter(", ").substringBefore(" GMT"),
        matchDate = kickoff.label.substringBefore(","),
        stadium = "${ground.name}, ${ground.city}",
        referee = mainReferee,
        attendance = "%,d".format(attendance)
    )
}

fun FixtureDetailsNetworkResponse.findPlayerName(personId: Int): String {
    val allPlayers: List<Player> = teamLists.flatMap { team ->
        team.lineup.map { lineup -> lineup.toPlayer() } + team.substitutes.map { substitute -> substitute.toPlayer() }
    }
    return allPlayers.firstOrNull { it.id == personId }?.displayName ?: "Unknown"
}