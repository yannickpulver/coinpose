package com.appswithlove.coinpose.model

import androidx.annotation.DrawableRes

data class Crypto(
    val name: String,
    val symbol: String,
    val price: Double,
    val percentChange24h: Double,
    @DrawableRes val icon: Int
)