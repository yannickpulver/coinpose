package com.appswithlove.coinpose.di

import com.appswithlove.coinpose.BuildConfig
import com.appswithlove.coinpose.data.remote.Api
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiClient(okHttpClient: OkHttpClient, json: Json): Api {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                it.proceed(
                    it.request().newBuilder()
                        .addHeader("X-CMC_PRO_API_KEY", BuildConfig.CMP_APIKEY)
                        .build()
                )
            }
            .build()
    }

}
