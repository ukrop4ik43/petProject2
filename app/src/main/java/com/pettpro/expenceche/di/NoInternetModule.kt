package com.pettpro.expenceche.di

import android.content.Context
import androidx.room.Room
import com.pettpro.data.repository.db.UserRepositoryImpl
import com.pettpro.data.repository.db.dao.UserDao
import com.pettpro.data.repository.db.room.UserDatabase
import com.pettpro.data.repository.no_internet.ConnectionCheckRepositoryImpl
import com.pettpro.data.repository.splashstorage.SplashStorageImpl
import com.pettpro.domain.db.UserRepository
import com.pettpro.domain.no_internet.ConnectionCheckRepository
import com.pettpro.domain.splashstorage.SplashStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NoInternetModule {
    @Provides
    @Singleton
    fun provideConnectionCheckRepository(@ApplicationContext context: Context): ConnectionCheckRepository {
        return ConnectionCheckRepositoryImpl(context)
    }

}
