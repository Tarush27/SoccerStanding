package com.tarush27.soccerstandings.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tarush27.soccerstandings.adapter.SoccerTeamAdapter
import com.tarush27.soccerstandings.databinding.TeamsActivityMainBinding
import com.tarush27.soccerstandings.model.SoccerTeam
import com.tarush27.soccerstandings.networking.RetrofitClient
import com.tarush27.soccerstandings.networking.TeamsService
import com.tarush27.soccerstandings.repository.TeamsRepository
import com.tarush27.soccerstandings.viewModel.TeamsViewModel
import com.tarush27.soccerstandings.viewModel.TeamsViewModelFactory

class TeamsMainActivity : AppCompatActivity() {
    private lateinit var binding: TeamsActivityMainBinding
    private lateinit var teamsViewModel: TeamsViewModel
    var teamsAdapter = SoccerTeamAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TeamsActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val teamsService: TeamsService = RetrofitClient.service
        val teamsRepository = TeamsRepository(teamsService)
        teamsViewModel = ViewModelProvider(
            this,
            TeamsViewModelFactory(teamsRepository)
        )[TeamsViewModel::class.java]
        setupTeamsRv()
        teamsViewModel.teamsDetailsResponse.observe(this) { response ->
            val soccerTeams = response.soccerTeams
            teamsAdapter.updateTeamsData(soccerTeams as ArrayList<SoccerTeam>)
        }
    }

    private fun setupTeamsRv() {
        teamsAdapter = SoccerTeamAdapter()
        binding.teamsRv.layoutManager = LinearLayoutManager(this)
        binding.teamsRv.adapter = teamsAdapter
    }
}