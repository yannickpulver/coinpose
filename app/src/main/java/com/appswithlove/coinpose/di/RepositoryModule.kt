package com.appswithlove.coinpose.di

import com.appswithlove.coinpose.data.CoinRepositoryImpl
import com.appswithlove.coinpose.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCoinRepository(coinRepositoryImpl: CoinRepositoryImpl): CoinRepository

}
