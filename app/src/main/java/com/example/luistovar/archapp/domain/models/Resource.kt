package com.example.luistovar.archapp.domain.models

import com.example.luistovar.archapp.domain.models.errors.Failure

// A generic class that contains data and status about loading this data.
sealed class Resource<T>(
    val data: T? = null,
    val failure: Failure? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(failure: Failure, data: T? = null) : Resource<T>(data, failure)
}

