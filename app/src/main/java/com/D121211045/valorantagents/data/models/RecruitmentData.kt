package com.D121211045.valorantagents.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class RecruitmentData(
    val counterId: String?,
    val endDate: String?,
    val levelVpCostOverride: Int?,
    val milestoneId: String?,
    val milestoneThreshold: Int?,
    val startDate: String?,
    val useLevelVpCostOverride: Boolean?
) : Parcelable