package com.applaunch.jcui.network

import com.applaunch.jcui.repository.BGMRepository
import com.applaunch.jcui.repository.BGMRepositoryImpl
import com.applaunch.jcui.ui.di.BGMHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*


@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun getHttpClient(httpClient: BGMHttpClient): HttpClient = httpClient.getHttpClient()

    @Provides
    fun getMoviesRepository(impl: BGMRepositoryImpl): BGMRepository = impl
}