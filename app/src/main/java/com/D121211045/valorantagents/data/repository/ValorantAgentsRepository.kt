package com.D121211045.valorantagents.data.repository

import com.D121211045.valorantagents.data.response.GetAgentsResponse
import com.D121211045.valorantagents.data.source.remote.ApiService

class ValorantAgentsRepository(private val apiService: ApiService) {

    suspend fun getValorantAgents(): GetAgentsResponse {
        return apiService.getValorantAgents()
    }
}