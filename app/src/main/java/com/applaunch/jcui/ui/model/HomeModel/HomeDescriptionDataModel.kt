package com.applaunch.jcui.ui.model.HomeModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeDescriptionDataModel(
    @SerialName("type")
    val type:String="",

    @SerialName("content")
    val content:String="",

    @SerialName("_id")
    val _id:String=""
)
