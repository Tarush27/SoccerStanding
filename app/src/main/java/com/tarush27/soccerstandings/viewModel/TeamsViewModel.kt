package com.tarush27.soccerstandings.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tarush27.soccerstandings.model.SoccerTeamResponse
import com.tarush27.soccerstandings.repository.TeamsRepository

class TeamsViewModel(private val teamsRepository: TeamsRepository) : ViewModel() {
    init {
        teamsRepository.getTeamDetails()
    }

    val teamsDetailsResponse: LiveData<SoccerTeamResponse> = teamsRepository.teamsResponse
}