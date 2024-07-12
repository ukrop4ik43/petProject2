package com.pettpro.expenceche.di

import com.pettpro.data.repository.add_expence_income.ActualTimeRepositoryImpl
import com.pettpro.data.repository.add_expence_income.AddExpenceIncomeVerifyingRepositoryImpl
import com.pettpro.domain.add_expence_income.ActualTimeRepository
import com.pettpro.domain.add_expence_income.AddExpenceIncomeVerifyingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class AddExpenceIncomeModule {
    @Provides
    internal fun provideAddExpenceIncomeVerifyingRepository(): AddExpenceIncomeVerifyingRepository {
        return AddExpenceIncomeVerifyingRepositoryImpl()
    }

    @Provides
    internal fun provideActualTimeRepository(): ActualTimeRepository {
        return ActualTimeRepositoryImpl()
    }

}