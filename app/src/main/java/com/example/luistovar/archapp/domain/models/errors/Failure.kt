package com.example.luistovar.archapp.domain.models.errors

sealed class Failure(val errorMessage: String? = null) {

    data class GeneralFailure(val message: String) : Failure(message)
    data class NetworkFailure(val message: String) : Failure(message)
//    object NetworkFailure : Failure()
}