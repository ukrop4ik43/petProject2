package com.pettpro.expenceche.di

import com.pettpro.data.repository.home.HomeScreenProviderImpl
import com.pettpro.data.repository.login.LoginVerifyingRepositoryImpl
import com.pettpro.domain.home.HomeScreenProvider
import com.pettpro.domain.login.LoginVerifyingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class HomeModule {
    @Provides
    internal fun provideHomeScreenProvider(): HomeScreenProvider {
        return HomeScreenProviderImpl()
    }

}