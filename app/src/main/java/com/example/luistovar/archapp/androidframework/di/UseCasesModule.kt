package com.example.luistovar.archapp.androidframework.di

import com.example.luistovar.archapp.domain.usecases.PeopleListSwUseCase
import com.example.luistovar.archapp.domain.usecases.implementation.PeopleListSwUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    factory<PeopleListSwUseCase> { PeopleListSwUseCaseImpl(get()) }
}