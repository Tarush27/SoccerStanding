package com.tarush27.soccerstandings.networking

import com.tarush27.soccerstandings.model.SoccerTeamResponse
import retrofit2.Call
import retrofit2.http.GET

interface TeamsService {

    @GET("teams")
    fun getTeams(): Call<SoccerTeamResponse>
}