package com.appswithlove.coinpose.domain.model

import androidx.annotation.DrawableRes

data class Crypto(
    val name: String,
    val symbol: String,
    val price: Double,
    val percentChange24h: Double,
    val iconUrl: String
) {

    val isUp get() = percentChange24h > 0
}