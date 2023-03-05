package com.tarush27.soccerstandings.model

import com.google.gson.annotations.SerializedName

data class SoccerTeamResponse(
    @SerializedName("data")
    val soccerTeams: List<SoccerTeam>
)