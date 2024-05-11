package com.pettpro.expenceche.di

import android.content.Context
import androidx.room.Room
import com.pettpro.data.repository.db.UserRepositoryImpl
import com.pettpro.data.repository.db.dao.UserDao
import com.pettpro.data.repository.db.room.UserDatabase
import com.pettpro.data.repository.registration.RegistrationVerifyingRepositoryImpl
import com.pettpro.data.repository.registration.ToastControlImpl
import com.pettpro.domain.db.UserRepository
import com.pettpro.domain.registration.RegistrationVerifyingRepository
import com.pettpro.domain.registration.ToastControl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RegistrationModule {
    @Provides
    internal fun provideURegistrationVerification(): RegistrationVerifyingRepository {
        return RegistrationVerifyingRepositoryImpl()
    }

    @Provides
    internal fun provideToastControl(@ApplicationContext context: Context): ToastControl {
        return ToastControlImpl(context)
    }


}