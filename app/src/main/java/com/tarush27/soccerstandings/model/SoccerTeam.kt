package com.tarush27.soccerstandings.model

import com.google.gson.annotations.SerializedName

data class SoccerTeam(
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("full_name")
    val full_name: String
)