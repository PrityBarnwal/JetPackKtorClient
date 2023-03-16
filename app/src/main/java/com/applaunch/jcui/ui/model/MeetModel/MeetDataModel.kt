package com.applaunch.jcui.ui.model.MeetModel

import com.applaunch.jcui.ui.model.HomeModel.HomeDescriptionDataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MeetDataModel(
    @SerialName("_id")
    val _id: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("streamType")
    val streamType: String? = null,
    @SerialName("webStartDate")
    val webStartDate: String? = null,
    @SerialName("webEndDate")
    val webEndDate: String? = null,
    @SerialName("link")
    val link: String? = null,
    @SerialName("createdAt")
    val date: String? = null,
    @SerialName("totalLikes")
    var totalLikes: Int = 0,
    @SerialName("isLike")
    var isLike: Boolean = false,
    @SerialName("isFavorite")
    var isFavorite: Boolean = false,
    @SerialName("video")
    val video: String? = null,
    @SerialName("description")
    val description: HomeDescriptionDataModel? = null,
    @SerialName("writtenBy")
    val writtenBy: String? = null,

    @SerialName("collectionId")
    val collectionId: String? = null,
)