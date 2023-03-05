package com.tarush27.soccerstandings.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tarush27.soccerstandings.repository.TeamsRepository

class TeamsViewModelFactory(private val teamsRepository: TeamsRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TeamsViewModel(teamsRepository) as T
    }
}