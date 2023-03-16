package com.applaunch.jcui.ui.model.HomeModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeDataModel(
    @SerialName("_id")
    val _id:String="",
    @SerialName("image")
    val image: String="",
    @SerialName("title")
    val title:String="",
    @SerialName("isFavorite")
    var isFavorite:Boolean = false,
    @SerialName("isLike")
    var isLike:Boolean = false,
    @SerialName("totalLikes")
    var totalLikes: Int =0,
    @SerialName("streamType")
    val streamType: String? = null,
    @SerialName("link")
    val link: String="",
    @SerialName("writtenBy")
    val writtenBy: String="",
    @SerialName("description")
    val description: HomeDescriptionDataModel? = null,
    @SerialName("createdAt")
    val date: String="",
    @SerialName("video")
    val video: String="",
    @SerialName("collectionId")
    val collectionId: String? = null,

    )
