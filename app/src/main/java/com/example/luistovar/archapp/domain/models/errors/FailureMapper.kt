package com.example.luistovar.archapp.domain.models.errors

import com.example.luistovar.archapp.domain.models.errors.exceptions.InvalidDataException
import com.example.luistovar.archapp.domain.models.errors.exceptions.NullOrEmptyListPeopleSwException
import com.example.luistovar.archapp.domain.models.errors.exceptions.NullResponseException
import org.chromium.net.NetworkException
import kotlin.Exception

class FailureMapper {

    companion object {

        fun map(exception: Exception): Failure {
            return when (exception) {
                is NetworkException -> {
                    Failure.GeneralFailure(exception.message ?: "")
                }
                is InvalidDataException -> {
                    Failure.GeneralFailure(exception.message ?: "")
                }
                is NullResponseException -> {
                    Failure.GeneralFailure(exception.message ?: "")
                }
                is NullOrEmptyListPeopleSwException -> {
                    Failure.GeneralFailure(exception.message ?: "")
                }
                else -> {
                    Failure.GeneralFailure(exception.message ?: "")
                }
            }
        }

        fun manageNetworkException(networkException: NetworkException): Failure {
            return Failure.NetworkFailure(networkException.message ?: "")
        }
    }
}