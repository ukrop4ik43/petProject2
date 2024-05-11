package com.pettpro.expenceche.di

import android.content.Context
import com.pettpro.data.repository.splashstorage.SplashStorageImpl
import com.pettpro.domain.splashstorage.SplashStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class SplashModule {
    @Provides
    @Singleton
    fun provideSplashStorage(@ApplicationContext context: Context): SplashStorage {
        return SplashStorageImpl(context)
    }
}