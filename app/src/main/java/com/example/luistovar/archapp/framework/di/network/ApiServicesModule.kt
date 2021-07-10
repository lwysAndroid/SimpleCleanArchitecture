package com.example.luistovar.archapp.framework.di.network

import com.example.luistovar.archapp.framework.network.webservices.api.StarWarsApi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServicesModule {

    @Singleton
    @Provides
    fun provideStarWarsApi(
        @Named("retrofit_star_wars_api") retrofit: Retrofit
    ): StarWarsApi {
        return retrofit.create(StarWarsApi::class.java)
    }
}