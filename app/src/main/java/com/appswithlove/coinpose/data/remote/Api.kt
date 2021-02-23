package com.appswithlove.coinpose.data.remote

import com.appswithlove.coinpose.data.remote.model.CryptoDataDto
import com.appswithlove.coinpose.data.remote.model.CryptoMetadataDto
import com.appswithlove.coinpose.data.remote.model.CryptoSingleDataDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getCryptos(@Query("limit") limit: Int = 20): CryptoDataDto

    @GET("v2/cryptocurrency/quotes/latest")
    suspend fun getCrypto(@Query("symbol") symbol: String): CryptoSingleDataDto

    @GET("v2/cryptocurrency/info")
    suspend fun getInfo(@Query("symbol") symbols: String): CryptoMetadataDto

}