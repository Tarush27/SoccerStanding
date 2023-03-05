package com.tarush27.soccerstandings.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tarush27.soccerstandings.model.SoccerTeamResponse
import com.tarush27.soccerstandings.networking.TeamsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamsRepository(val teamsService: TeamsService) {

    private val _teamsResponse = MutableLiveData<SoccerTeamResponse>()
    val teamsResponse: LiveData<SoccerTeamResponse> = _teamsResponse
    fun getTeamDetails() {
        val response: Call<SoccerTeamResponse> = teamsService.getTeams()
        response.enqueue(object : Callback<SoccerTeamResponse> {
            override fun onResponse(
                call: Call<SoccerTeamResponse>,
                response: Response<SoccerTeamResponse>
            ) {
                _teamsResponse.value = response.body()
            }

            override fun onFailure(call: Call<SoccerTeamResponse>, t: Throwable) {
                Log.d("repo", t.message.toString())
            }

        })
    }

}