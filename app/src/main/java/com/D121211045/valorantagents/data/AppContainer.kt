package com.makassar.newsappcompose.data

import com.D121211045.valorantagents.data.repository.ValorantAgentsRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.D121211045.valorantagents.data.source.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val valorantAgentsRepository: ValorantAgentsRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://valorant-api.com/"

    val json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val valorantAgentsRepository: ValorantAgentsRepository
        get() = ValorantAgentsRepository(retrofitService)

}