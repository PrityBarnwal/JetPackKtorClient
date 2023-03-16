package com.applaunch.jcui.ui.model.MeetModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MeetDataResponse(
    @SerialName("data")
    val data: List<MeetDataModel>
)
