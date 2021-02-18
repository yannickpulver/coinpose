package com.appswithlove.coinpose.data

import com.appswithlove.coinpose.R
import com.appswithlove.coinpose.data.remote.Api
import com.appswithlove.coinpose.data.remote.mapper.CryptoDataDtoMapper
import com.appswithlove.coinpose.domain.CoinRepository
import com.appswithlove.coinpose.domain.model.Crypto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(val api: Api, val mapper: CryptoDataDtoMapper) : CoinRepository {
    override fun getCrypto(): Flow<List<Crypto>> = flow {
        val cryptoData = api.getLatestCrypto()
        emit(mapper.map(cryptoData))
    }

    private fun getCryptos(): List<Crypto> {
        return listOf(
            Crypto("Bitcoin", "BTC", 49595.41, 2.62, "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"),
            Crypto("Ethereum", "ETH", 1774.90, -0.90, "https://s2.coinmarketcap.com/static/img/coins/64x64/2.png"),
            Crypto("Cardano", "ADA", 0.8769, 0.99, "https://s2.coinmarketcap.com/static/img/coins/64x64/3.png"),
            Crypto("Polkadot", "DOT", 29.88, 6.94, "https://s2.coinmarketcap.com/static/img/coins/64x64/4.png")
        )
    }

}