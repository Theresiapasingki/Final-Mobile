package com.D121211045.valorantagents.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Ability(
    val description: String?,
    val displayIcon: String?,
    val displayName: String?,
    val slot: String?
) : Parcelable