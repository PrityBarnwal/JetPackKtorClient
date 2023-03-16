package com.applaunch.jcui.ui.di

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import javax.inject.Inject

class BGMHttpClient @Inject constructor() {
    fun getHttpClient() = HttpClient(Android) {

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })

            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v(TAG_KTOR_LOGGER, message)
                }

            }
            level = LogLevel.ALL
        }

        install(ResponseObserver) {
            onResponse { response ->
                Log.d(TAG_HTTP_STATUS_LOGGER, "${response.status.value}")
            }
        }

        install(DefaultRequest) {
            contentType(ContentType.Application.Json.withParameter("charset", "utf-8"))
            header("x-api-key", "cwcLz4ywd85KXeRT3menxVJrWCTJjn37HrU2Z5tbN6yYzhtBSA4EEapmXqMDLvgnQah7uyd2feUfRFqQUkSkRQLsPBVp6cQQ4PggN9Ft7fEcaS28656TnGNkwCQTe7y")
            header("x-app-version", "1.0.0")
            header("x-app-deviceType", "android")
            header("Accept-Language", "en")

            header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2M2M4ZjJhZmNlNTVjYmJhYmI3NWYzODUiLCJkZXZpY2VUb2tlbiI6ImRzZnNkZnNkZmRkczQ4ODc4NzQ1NTQ1NDU0MjQ0ODRzZHNkZjRzODd3ZmQ0YzVzNGY4N2U4N3JkdjJjMXYyMXZnc2U1Z3Q0ZWc4NzQ4NnM1NGQ1czRmd2E0ZjhmNzRydzhmNGQiLCJpYXQiOjE2Nzg5NDIzNzksImV4cCI6MTY4MTUzNDM3OX0.WN77T7-ufRak-83Yzdwm6v4A3jGK6JVtrWsDE0jlQx4")
        }
    }
    companion object {
        private const val TIME_OUT = 10_000
        private const val TAG_KTOR_LOGGER = "ktor_logger:"
        private const val TAG_HTTP_STATUS_LOGGER = "http_status:"
    }
}