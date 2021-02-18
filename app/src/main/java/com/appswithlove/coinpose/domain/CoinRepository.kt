package com.appswithlove.coinpose.domain

import com.appswithlove.coinpose.domain.model.Crypto
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    fun getCrypto(): Flow<List<Crypto>>
}