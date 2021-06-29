package com.example.luistovar.archapp.androidframework.di

import com.example.luistovar.archapp.androidframework.network.NetWorkConfiguration
import org.koin.dsl.module

val networkModule = module {
    factory { NetWorkConfiguration.getStarWarsApi() }
}