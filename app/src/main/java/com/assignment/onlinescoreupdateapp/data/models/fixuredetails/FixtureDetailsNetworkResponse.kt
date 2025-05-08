package com.assignment.onlinescoreupdateapp.data.models.fixuredetails


import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.FixtureResult
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

    return FixtureResult(
        homeTeam = home.team.toTeamScore(),
        awayTeam = away.team.toTeamScore(),
        fullTimeScore = "${home.score} - ${away.score}",
        halfTimeScore = "HT ${halfTimeScore.homeScore} - ${halfTimeScore.awayScore}",
        events = events
            .filter { it.type == "G" }
            .map { it.toMatchEvent(teamLists, teams) },
        kickOffTime = kickoff.label.substringAfter(", ").substringBefore(" GMT"),
        matchDate = kickoff.label.substringBefore(","),
        stadium = "${ground.name}, ${ground.city}",
        attendance = "%,d".format(attendance),
        referee = matchOfficials.firstOrNull { it.role == "MAIN" }?.name?.display ?: "Unknown"
    )
}