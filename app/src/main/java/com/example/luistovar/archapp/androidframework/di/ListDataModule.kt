package com.example.luistovar.archapp.androidframework.di

import com.example.luistovar.archapp.presentation.listdata.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val listDataModule = module {
    viewModel { ListViewModel(get()) }
}
