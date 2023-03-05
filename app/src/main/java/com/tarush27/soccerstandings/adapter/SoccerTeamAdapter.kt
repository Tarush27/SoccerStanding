package com.tarush27.soccerstandings.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.tarush27.soccerstandings.R
import com.tarush27.soccerstandings.model.SoccerTeam

class SoccerTeamAdapter : RecyclerView.Adapter<SoccerTeamAdapter.SoccerTeamViewHolder>() {

    inner class SoccerTeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamCityName: TextView = itemView.findViewById(R.id.teamCityTv)
        val teamAbbreviation: TextView = itemView.findViewById(R.id.teamAbbreviationTv)
        val teamFullName: TextView = itemView.findViewById(R.id.teamFullNameTv)
    }

    val teams: ArrayList<SoccerTeam> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoccerTeamViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.single_soccer_team, parent, false)
        return SoccerTeamViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: SoccerTeamViewHolder, position: Int) {
        val soccerTeam = teams[position]
        val context = holder.itemView.context as AppCompatActivity
        holder.teamFullName.text =
            "${context.resources.getString(R.string.fullName)} : ${soccerTeam.full_name}"
        holder.teamAbbreviation.text =
            "${context.resources.getString(R.string.abbreviation)} : ${soccerTeam.abbreviation}"
        holder.teamCityName.text =
            "${context.resources.getString(R.string.cityName)} : ${soccerTeam.city}"
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    fun updateTeamsData(soccerTeams: ArrayList<SoccerTeam>) {
        teams.addAll(soccerTeams)
        notifyDataSetChanged()
    }
}