package com.D121211045.valorantagents.data.response

import com.D121211045.valorantagents.data.models.Data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetAgentsResponse(
    @SerialName("data")
    val data : List<Data>,
    @SerialName("status")
    val status: Int
)