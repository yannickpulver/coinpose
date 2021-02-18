package com.appswithlove.coinpose.data.remote

import com.appswithlove.coinpose.data.remote.model.CryptoDataDto
import com.appswithlove.coinpose.data.remote.model.CryptoMetadataDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getLatestCrypto(@Query("limit") limit: Int = 10): CryptoDataDto

    @GET("v2/cryptocurrency/info")
    suspend fun getInfo(@Query("symbol") symbols: String): CryptoMetadataDto

}