package com.applaunch.jcui.repository


import com.applaunch.jcui.network.Resources
import com.applaunch.jcui.ui.model.HomeModel.HomeDataModel
import com.applaunch.jcui.ui.model.MeetModel.MeetDataModel

interface BGMRepository {

    suspend fun getHome(): Resources<List<HomeDataModel>>

    suspend fun getMeet(): Resources<List<MeetDataModel>>

}