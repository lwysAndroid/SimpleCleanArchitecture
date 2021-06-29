package com.example.luistovar.archapp.androidframework.di

import com.example.luistovar.archapp.presentation.home.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { MainViewModel() }
}