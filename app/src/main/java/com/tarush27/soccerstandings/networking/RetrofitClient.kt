package com.tarush27.soccerstandings.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.balldontlie.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(TeamsService::class.java)
}