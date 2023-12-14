package com.D121211045.valorantagents.data.source.remote

import com.D121211045.valorantagents.data.response.GetAgentsResponse
import retrofit2.http.GET

interface ApiService {
//    @Headers(
//        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5NGM1NjgxYWE3MTdjODlmZTdmMmE1ZTcyYTNhNWZmZCIsInN1YiI6IjYyZTRhOTJiZmM1ZjA2MDA1OWMyOGUwOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fhTRa5WuoK85MU20AmtsDA7PAZNfBR4DrRs6a31a9Rc"
//    )
    @GET("v1/agents")
    suspend fun getValorantAgents() : GetAgentsResponse
}
