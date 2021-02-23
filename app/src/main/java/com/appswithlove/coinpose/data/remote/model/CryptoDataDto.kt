package com.appswithlove.coinpose.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoDataDto(
    val data: List<CryptoDto>
)

@Serializable
data class CryptoSingleDataDto(
    val data: Map<String,List<CryptoDto>>
)

@Serializable
data class CryptoDto(
    val id: Int,
    val name: String,
    val symbol: String,
    val quote: QuoteDataDto
)

@Serializable
data class QuoteDataDto(
    val USD: QuoteDto
)

@Serializable
data class QuoteDto(
    val price: Double,
    @SerialName("percent_change_24h")
    val percentChange24h: Double
)
