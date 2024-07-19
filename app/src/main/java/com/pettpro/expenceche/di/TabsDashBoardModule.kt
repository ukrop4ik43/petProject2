package com.pettpro.expenceche.di

import com.pettpro.data.repository.add_expence_income.ActualTimeRepositoryImpl
import com.pettpro.data.repository.add_expence_income.AddExpenceIncomeVerifyingRepositoryImpl
import com.pettpro.data.repository.tabs_dashboard.ChartDataExtractorImpl
import com.pettpro.domain.add_expence_income.ActualTimeRepository
import com.pettpro.domain.add_expence_income.AddExpenceIncomeVerifyingRepository
import com.pettpro.domain.tabs_dashboard.ChartDataExtractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class SingletonComponent {
    @Provides
    internal fun provideChartDataExtractor(): ChartDataExtractor {
        return ChartDataExtractorImpl()
    }



}