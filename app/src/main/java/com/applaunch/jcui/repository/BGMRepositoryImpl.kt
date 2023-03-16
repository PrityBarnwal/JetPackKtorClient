package com.applaunch.jcui.repository

import com.applaunch.jcui.network.Constants.BASE_URL
import com.applaunch.jcui.network.Resources
import com.applaunch.jcui.ui.model.HomeModel.HomeDataModel
import com.applaunch.jcui.ui.model.HomeModel.HomeDataResponse
import com.applaunch.jcui.ui.model.MeetModel.MeetDataModel
import com.applaunch.jcui.ui.model.MeetModel.MeetDataResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject


private const val HOME = "${BASE_URL}/app/home/thumbnail"
private const val MEET = "${BASE_URL}/app/media/all-thumbnails/1/200"


class BGMRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : BGMRepository {
    override suspend fun getHome(): Resources<List<HomeDataModel>> {
        return try {
            Resources.Success(
                httpClient.get<HomeDataResponse> {
                    url(HOME)
                }.data
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resources.Failure(e)
        }
    }

    override suspend fun getMeet(): Resources<List<MeetDataModel>> {
        return try {
            Resources.Success(
                httpClient.post<MeetDataResponse>{
                    url(MEET)
                }.data
            )
        }catch (e:Exception){
            e.printStackTrace()
            Resources.Failure(e)
        }
    }
}