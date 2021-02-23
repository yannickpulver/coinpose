package com.appswithlove.coinpose.data.remote.mapper

import com.appswithlove.coinpose.data.remote.model.CryptoDataDto
import com.appswithlove.coinpose.data.remote.model.CryptoDto
import com.appswithlove.coinpose.domain.model.Crypto
import javax.inject.Inject

class CryptoDataDtoMapper @Inject constructor() {

    fun map(entity: CryptoDataDto): List<Crypto> {
        return entity.data.map(::map)
    }

    fun map(entity: CryptoDto) = Crypto(
        name = entity.name,
        symbol = entity.symbol,
        price = entity.quote.USD.price,
        percentChange24h = entity.quote.USD.percentChange24h,
        iconUrl = "https://s2.coinmarketcap.com/static/img/coins/64x64/${entity.id}.png"
    )

    fun mapToSymbolString(entity: CryptoDataDto): String {
        return entity.data.joinToString(",") { it.symbol }
    }

}