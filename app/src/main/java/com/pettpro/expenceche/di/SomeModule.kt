package com.pettpro.expenceche.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class SomeModule {


    @Provides
    @Singleton
    fun provideSome(){

    }
}