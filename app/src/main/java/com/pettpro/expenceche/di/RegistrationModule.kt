package com.pettpro.expenceche.di

import android.content.Context
import com.pettpro.data.repository.registration.FirebaseUsersRegistrationRepositoryImpl
import com.pettpro.data.repository.registration.RegistrationVerifyingRepositoryImpl
import com.pettpro.data.repository.registration.ToastControlImpl
import com.pettpro.domain.registration.FirebaseUsersRegistrationRepository
import com.pettpro.domain.registration.RegistrationVerifyingRepository
import com.pettpro.domain.registration.ToastControl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RegistrationModule {
    @Provides
    internal fun provideURegistrationVerification(): RegistrationVerifyingRepository {
        return RegistrationVerifyingRepositoryImpl()
    }

    @Provides
    internal fun provideGetAllUsersRepository(@ApplicationContext context: Context): FirebaseUsersRegistrationRepository {
        return FirebaseUsersRegistrationRepositoryImpl(context)
    }


    @Provides
    internal fun provideToastControl(@ApplicationContext context: Context): ToastControl {
        return ToastControlImpl(context)
    }


}