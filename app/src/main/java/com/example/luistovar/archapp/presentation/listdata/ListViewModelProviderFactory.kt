package com.example.luistovar.archapp.presentation.listdata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.luistovar.archapp.domain.usecases.PeopleListSwUseCase
import java.lang.Exception

class ListViewModelProviderFactory(private val peopleListSwUseCase: PeopleListSwUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == ListViewModel::class.java) {
            ListViewModel(peopleListSwUseCase) as T
        } else {
            throw Exception("This factory is only for ListViewModel")
        }
    }
}