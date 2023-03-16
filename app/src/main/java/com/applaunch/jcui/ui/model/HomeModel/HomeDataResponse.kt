package com.applaunch.jcui.ui.model.HomeModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeDataResponse(
    @SerialName("data")
    val data: List<HomeDataModel>
)
