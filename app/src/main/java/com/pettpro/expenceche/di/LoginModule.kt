package com.pettpro.expenceche.di

import com.pettpro.data.repository.login.LoginVerifyingRepositoryImpl
import com.pettpro.domain.login.LoginVerifyingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class LoginModule {
    @Provides
    internal fun provideURegistrationVerification(): LoginVerifyingRepository {
        return LoginVerifyingRepositoryImpl()
    }

}