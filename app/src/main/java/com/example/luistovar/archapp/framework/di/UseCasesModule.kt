package com.example.luistovar.archapp.framework.di

import com.example.luistovar.archapp.usecases.PeopleListSwUseCase
import com.example.luistovar.archapp.usecases.implementation.PeopleListSwUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCasesModule {

    @Binds
    abstract fun bindPeopleListSwUseCase(
        peopleListSwUseCaseImpl: PeopleListSwUseCaseImpl
    ): PeopleListSwUseCase
}