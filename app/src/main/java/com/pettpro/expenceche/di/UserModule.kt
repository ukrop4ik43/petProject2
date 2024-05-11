package com.pettpro.expenceche.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.pettpro.data.repository.db.UserRepositoryImpl
import com.pettpro.data.repository.db.dao.UserDao
import com.pettpro.data.repository.db.room.UserDatabase
import com.pettpro.data.repository.splashstorage.SplashStorageImpl
import com.pettpro.domain.db.UserRepository
import com.pettpro.domain.splashstorage.SplashStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UserModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "coins.db"
        ).build()
    }
    @Provides
    internal fun provideUserDao(appDatabase: UserDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepositoryImpl(userDao)
    }

}