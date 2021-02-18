package com.appswithlove.coinpose.data.remote.mapper

import com.appswithlove.coinpose.data.remote.model.CryptoDataDto
import com.appswithlove.coinpose.domain.model.Crypto
import javax.inject.Inject

class CryptoDataDtoMapper @Inject constructor() {

    fun map(entity: CryptoDataDto): List<Crypto> {
        return entity.data.map {
            Crypto(
                name = it.name,
                symbol = it.symbol,
                price = it.quote.USD.price,
                percentChange24h = it.quote.USD.percentChange24h,
                iconUrl = "https://s2.coinmarketcap.com/static/img/coins/64x64/${it.id}.png"
            )
        }
    }

    fun mapToSymbolString(entity: CryptoDataDto): String {
        return entity.data.joinToString(",") { it.symbol }
    }

}