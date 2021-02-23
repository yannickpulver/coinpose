package com.appswithlove.coinpose.domain

import com.appswithlove.coinpose.domain.model.Crypto
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    fun getCryptos(): Flow<List<Crypto>>
    fun getCrypto(symbol: String): Flow<Crypto?>
}